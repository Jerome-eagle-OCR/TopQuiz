package com.jr.topquiz.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jr.topquiz.R;
import com.jr.topquiz.model.User;

/**
 * based on Florian Ponroy code for OCR
 */

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 33;
    private SharedPreferences mPreferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUser = new User();

        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetingText = findViewById(R.id.activity_main_greeting_txt);
        mNameInput = findViewById(R.id.activity_main_name_input);
        mPlayButton = findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        if (mPreferences.getString(PREF_KEY_FIRSTNAME, null) != null) {
            welcomeKnownPlayer();
        }

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(v -> {
            // User clicked let's play button
            mUser.setFirstName(mNameInput.getText().toString());

            mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstName()).apply();

            Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
            startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
        });
    }

    private void welcomeKnownPlayer() {
        String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);
        int score = mPreferences.getInt(PREF_KEY_SCORE, 0);
        String welcomeBackText = "Bon retour dans le Top Quiz, " + firstname
                + " !\nTon score précédent était " + score
                + ".\nFeras-tu mieux cette fois ?";
        mGreetingText.setText(welcomeBackText);
        mNameInput.setText(firstname);
        //mNameInput.setSelection(firstname.length());
        mPlayButton.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            welcomeKnownPlayer();
        }
    }
}
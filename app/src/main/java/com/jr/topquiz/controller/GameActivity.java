package com.jr.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jr.topquiz.R;

public class GameActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private Button mAnswerBtn1;
    private Button mAnswerBtn2;
    private Button mAnswerBtn3;
    private Button mAnswerBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Wiring widgets
        mQuestionText = findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = findViewById(R.id.activity_game_answer4_btn);

        mAnswerBtn1.setEnabled(false);
        mAnswerBtn2.setEnabled(false);
        mAnswerBtn3.setEnabled(false);
        mAnswerBtn4.setEnabled(false);

        mAnswerBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAnswerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAnswerBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAnswerBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
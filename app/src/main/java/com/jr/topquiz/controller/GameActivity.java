package com.jr.topquiz.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jr.topquiz.R;
import com.jr.topquiz.model.Question;
import com.jr.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionTextView;
    private Button mAnswerBtn1;
    private Button mAnswerBtn2;
    private Button mAnswerBtn3;
    private Button mAnswerBtn4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    // Get tag of clicked button and toast msg depending on right or wrong answer
    @Override
    public void onClick(View v) {
        int playerAnswerIndex = (int) v.getTag();
        if (playerAnswerIndex == mCurrentQuestion.getAnswerIndex()) {
            // Right answer
            Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show();
        } else {
            // Wrong answer
            Toast.makeText(this, "Incorrect...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Wiring widgets
        mQuestionTextView = findViewById(R.id.activity_game_question_text);
        mAnswerBtn1 = findViewById(R.id.activity_game_answer1_btn);
        mAnswerBtn2 = findViewById(R.id.activity_game_answer2_btn);
        mAnswerBtn3 = findViewById(R.id.activity_game_answer3_btn);
        mAnswerBtn4 = findViewById(R.id.activity_game_answer4_btn);

        // Naming buttons with tag
        mAnswerBtn1.setTag(0);
        mAnswerBtn2.setTag(1);
        mAnswerBtn3.setTag(2);
        mAnswerBtn4.setTag(3);

        // Adds listeners on each button
        mAnswerBtn1.setOnClickListener(this);
        mAnswerBtn2.setOnClickListener(this);
        mAnswerBtn3.setOnClickListener(this);
        mAnswerBtn4.setOnClickListener(this);

        mQuestionBank = this.generateQuestions();
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    // Displays question and 4 possible answers in each button
    private void displayQuestion(final Question question) {
            mQuestionTextView.setText(question.getQuestion());
            mAnswerBtn1.setText((question.getChoiceList().get(0)));
            mAnswerBtn2.setText((question.getChoiceList().get(1)));
            mAnswerBtn3.setText((question.getChoiceList().get(2)));
            mAnswerBtn4.setText((question.getChoiceList().get(3)));
    }

    // Generate a QuestionBank
    public QuestionBank generateQuestions() {

        Question question1 = new Question("Quel est le nom du président français actuel?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("Combien y a-t-il de pays dans l'UE?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Qui est le créateur d'Android?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("En quelle année le 1er Homme a-t-il marché sur la Lune?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("Quelle est la capitale de la Roumanie?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Qui a peint Mona Lisa?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("Dans quelle ville st enterré le compositeur Frédéric Chopin?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("Quel est le domaine de la Belgique?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("A quel numéro de rue habite les Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(
                question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }
}
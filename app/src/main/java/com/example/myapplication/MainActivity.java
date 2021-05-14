package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private Button yesButton, noButton, answerButton;
    private TextView questionTextView;
    private Question[] questions = {
            new Question(R.string.question0, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, false),
    };
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesButton = findViewById(R.id.buttonYes);
        noButton = findViewById(R.id.buttonNo);
        answerButton = findViewById(R.id.buttonAnswer);
        questionTextView = findViewById(R.id.questionTextView);

        questionTextView.setText(questions[questionIndex].getQuestionResId());
        answerButton.setOnClickListener(this::answerButton_onClick);
        yesButton.setOnClickListener(this::yesButton_onClick);
        noButton.setOnClickListener(this::noButton_onClick);
    }

    public void yesButton_onClick(View view) {
        if (questions[questionIndex].isAnswerTrue()) {
            Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        }
        questions[questionIndex].setUserAnswer(true);
        questionIndex++;
        if (questionIndex < questions.length) {
            questionTextView.setText(questions[questionIndex].getQuestionResId());
        } else {
            showResults();
        }
    }

    public void noButton_onClick(View view) {
        if (questions[questionIndex].isAnswerTrue()) {
            Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
        }
        questions[questionIndex].setUserAnswer(false);
        questionIndex++;
        if (questionIndex < questions.length) {
            questionTextView.setText(questions[questionIndex].getQuestionResId());
        } else {
            showResults();
        }
    }

    public void answerButton_onClick(View view) {
        Intent showAnswer = new Intent(MainActivity.this, AnswerActivity.class);
        showAnswer.putExtra("answer", questions[questionIndex].isAnswerTrue());
        startActivity(showAnswer);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("questionIndex", questionIndex);
    }

    private void showResults(){
        Intent result = new Intent(MainActivity.this,ResultActivity.class);
        result.putExtra("questions",questions);
        startActivity(result);
    }
}
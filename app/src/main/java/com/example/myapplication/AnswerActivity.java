package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView answerTextView;
    private boolean isAnswerTrue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        isAnswerTrue = getIntent().getBooleanExtra("answer", false);
        if(savedInstanceState != null){
            isAnswerTrue = savedInstanceState.getBoolean("isAnswerTrue");
        }

        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(isAnswerTrue ? R.string.yes : R.string.no);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("isAnswerTrue", isAnswerTrue);
    }

}
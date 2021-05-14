package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TableLayout resultTable;
    Question[] questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTable = findViewById(R.id.result_table);

        questions = (Question[]) getIntent().getSerializableExtra("questions");
        if(savedInstanceState != null){
            questions = (Question[]) savedInstanceState.getSerializable("questions");
        }

        for(Question question: questions)
        {
            TableRow row = new TableRow(this);
            TextView quest = new TextView(this);
            TextView corr = new TextView(this);
            quest.setText(question.getQuestionResId());
            corr.setText(question.isAnswerTrue() == question.getUserAnswer()? R.string.correct:R.string.incorrect);
            row.addView(quest ,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            row.addView(corr ,new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            resultTable.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("questions", questions);
    }
}
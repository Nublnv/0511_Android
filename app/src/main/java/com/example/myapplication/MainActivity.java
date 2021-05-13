package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Button yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yesButton = findViewById(R.id.buttonYes);
        noButton = findViewById(R.id.buttonNo);
        yesButton.setOnClickListener(this::yesButton_onClick);
        noButton.setOnClickListener(this::noButton_onClick);
    }

    public void yesButton_onClick(View view)
    {
        Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
    }

    public void noButton_onClick(View view)
    {
        Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
    }
}
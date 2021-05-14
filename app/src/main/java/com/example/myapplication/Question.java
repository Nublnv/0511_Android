package com.example.myapplication;

import java.io.Serializable;

public class Question implements Serializable {
    private int questionResId; // тут лежит id вопроса
    private boolean answerTrue; // какой должен быть ответ
    private boolean userAnswer;

    public Question(int questionResId, boolean answerTrue) {
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public boolean getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer)
    {
        this.userAnswer = userAnswer;
    }
}
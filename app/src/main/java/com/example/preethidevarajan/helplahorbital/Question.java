package com.example.preethidevarajan.helplahorbital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Question {

    private String question;
    private String username;
    private String answer;

    public Question(String question, String username, String answer){

        this.question = question;
        this.username = username;
        this.answer = answer;

    }

    public Question(String question, String username){

        this.question = question;
        this.username = username;

    }

    public String getQuestion() {
        return this.question;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}

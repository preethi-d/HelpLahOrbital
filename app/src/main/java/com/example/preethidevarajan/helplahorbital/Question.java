package com.example.preethidevarajan.helplahorbital;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Question implements Parcelable{

    private String question;
    private String username;
    private List<String> answerList;

    public Question(String question, String username, List<String> answerList){

        this.question = question;
        this.username = username;
        this.answerList = answerList;

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

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAnswer(String answer) {
        this.answerList.add(answer);
    }


    public Question() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

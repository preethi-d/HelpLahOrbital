package com.example.preethidevarajan.helplahorbital;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class Question {

    private String question;
    private List<Answer> answerList;

    public Question(String question, List<Answer> answerList){

        this.question = question;
        this.answerList = answerList;

    }

    public Question(String question){

        this.question = question;

    }

    public String getQuestion() {
        return this.question;
    }

    /*public String getUsername() {
        return this.username;
    }
    */

    public void setQuestion(String question) {
        this.question = question;
    }

    /*public void setUsername(String username) {
        this.username = username;
    }
    */

    //add answer to the list
    public void addAnswer(Answer Answer) {
        this.answerList.add(Answer);
    }


    public Question() {

    }

}

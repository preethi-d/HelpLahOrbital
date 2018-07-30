package com.example.preethidevarajan.helplahorbital;

public class Answer {
    String answer;
    //String username;
    //int numOfLikes;


    public Answer(String answer) {
        this.answer = answer;
    }

    /*public Answer(String answer, String username, int numOfLikes) {
        this.answer = answer;
        this.username = username;
        this.numOfLikes = numOfLikes;
    }
    */

    public String getAnswer() {
        return answer;
    }

   /* public String getUsername() {
        return username;
    }

    public Integer getNumOfLikes() {
        return numOfLikes;
    }
    */

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /*public void setUsername(String username) {
        this.username = username;
    }

    public void setNumOfLikes(Integer numOfLikes) {
        this.numOfLikes = numOfLikes;
    }
    */
}

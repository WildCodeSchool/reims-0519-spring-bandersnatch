package com.wildcodeschool.bandersnatch.entities;

public class Score {

    private int id;
    private String nickname;
    private int userScore;

   

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setName(String nickname) {
        this.nickname = nickname;
    }

    public int getuserScore() {
        return userScore;
    }
    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
    public Score(){

    }

    public Score(int id, String nickname, int userScore) {
    this.id = id;
    this.nickname = nickname;
    this.userScore = userScore;
    }
}
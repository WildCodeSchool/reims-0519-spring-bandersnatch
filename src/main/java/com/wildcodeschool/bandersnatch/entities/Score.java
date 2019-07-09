package com.wildcodeschool.bandersnatch.entities;

public class Score {

    private int id;
    private String nickname;
    private int user_score;

   

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

    public int getUser_score() {
        return user_score;
    }
    public void setUserScore(int user_score) {
        this.user_score = user_score;
    }
    public Score(){

    }

    public Score(int id, String nickname, int user_score) {
    this.id = id;
    this.nickname = nickname;
    this.user_score = user_score;
    }
}
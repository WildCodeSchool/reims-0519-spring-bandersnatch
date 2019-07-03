package com.wildcodeschool.bandersnatch.entities;

public class Scores {

    private int id;
    private String nickname;
    private int user_score;

    public Scores(int id, String nickname, int user_score) {
        this.id = id;
        this.nickname = nickname;
        this.user_score = user_score;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getUser_score() {
        return user_score;
    }
}
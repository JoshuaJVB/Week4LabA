package com.groupa.week4laba.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(unique = true)
    private String username;
    private Long totalScore;
    private Long level;

    public User(){}

    public User(String username){
        this.username = username;
        totalScore = 0L;
        level = 1L;
    }

    public void setScore(Long num){
        totalScore += num;
        addLevel();
    }

    public void addLevel(){
        level++;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
}

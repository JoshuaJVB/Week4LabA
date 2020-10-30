package com.groupa.week4laba.game;

public interface Game {
    int LEADERBOARD_LENGTH = 5;
    void play();
    Long getScore() throws UnsupportedOperationException;
    Long[] getScores() throws UnsupportedOperationException;
}

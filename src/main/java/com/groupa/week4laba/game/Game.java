package com.groupa.week4laba.game;

public interface Game {
    void play();
    Long getScore() throws UnsupportedOperationException;
    Long[] getScores() throws UnsupportedOperationException;
    int getLeaderboardLength();
}

package com.groupa.week4laba.game;

public class Random implements Game {
    private static final int LEADERBOARD_LENGTH = 5;

    private Long score;

    @Override
    public void play() {
        score = Math.round(Math.random() * Long.MAX_VALUE);
    }

    @Override
    public Long getScore() throws UnsupportedOperationException {
        return score;
    }

    @Override
    public Long[] getScores() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getLeaderboardLength() {
        return LEADERBOARD_LENGTH;
    }
}

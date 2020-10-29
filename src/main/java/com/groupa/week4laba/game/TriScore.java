package com.groupa.week4laba.game;

public class TriScore implements Game {
    private static final int LEADERBOARD_LENGTH = 5;

    private Long[] score;

    @Override
    public void play() {
        score = new Long[4];

        score[0] = Math.round(Math.random() * 9999.0);
        score[1] = Math.round(Math.random() * 999.0);
        score[2] = Math.round(Math.random() * 999.0);
        score[3] = (score[0] * 1000000) + (score[1] * 1000) + score[2];
    }

    @Override
    public Long getScore() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Long[] getScores() throws UnsupportedOperationException {
        return score;
    }

    @Override
    public int getLeaderboardLength() {
        return LEADERBOARD_LENGTH;
    }
}

package com.groupa.week4laba.game;

public class Random implements Game {
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
}

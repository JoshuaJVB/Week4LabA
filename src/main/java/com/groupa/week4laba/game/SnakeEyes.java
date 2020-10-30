package com.groupa.week4laba.game;

public class SnakeEyes implements Game {
    private static final int ROUNDS = 500000;
    private static final Long POINTS = 42L;


    private Long score;

    @Override
    public void play() {
        score = 0L;

        for (int i = 0; i < ROUNDS; i++) {
            long die1 = Math.round(Math.random() * 5.0) + 1L;
            long die2 = Math.round(Math.random() * 5.0) + 1L;

            if (die1 == 1L && die2 == 1L) {
                score += POINTS;
            }
        }
    }

    @Override
    public Long getScore() {
        return score;
    }

    @Override
    public Long[] getScores() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}

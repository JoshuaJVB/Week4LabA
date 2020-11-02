package com.groupa.week4laba.game;

/**
 * <p>The SnakeEyes game rolls two 6-sided dice and checks for snake eyes. If the check succeeds, the number of POINTS
 * is awared.</p>
 *
 * <p>This game is played the amount of times as setup in ROUNDS.</p>
 *
 * <p>The final score is a summation of the POINTS awarded.</p>
 */
public class SnakeEyes implements Game {
    private static final int ROUNDS = 1000000;
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

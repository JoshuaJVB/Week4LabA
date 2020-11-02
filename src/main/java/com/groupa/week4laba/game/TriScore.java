package com.groupa.week4laba.game;

/**
 * <p>The TriScore game randomly picks 3 scores and then combines them into a final score. All 4 scores are returned
 * by the {@link #getScores()} method.</p>
 *
 * <p>As implemented, the first score ranges from 0 to 9,999. The second score, from 0 to 999, the third score, also
 * from 0 to 999.</p>
 *
 * <p>The final score is made up of the first score, for the millions, the second score, for the thousands, and the
 * third score, for the hundreds.</p>
 */
public class TriScore implements Game {
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
        return score[3];
    }

    @Override
    public Long[] getScores() throws UnsupportedOperationException {
        return score;
    }
}

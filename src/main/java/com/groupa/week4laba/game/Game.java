package com.groupa.week4laba.game;

/**
 * <p>This interface represents a Game that can be played. The {@link #play()} method is used ot play the game. The
 * game can either return a single score ({@link #getScore()}) or an array of scores ({@link #getScores()})). To
 * support that, an {@link UnsupportedOperationException} will be thrown on the method not implemented.</p>
 *
 * <p>The {@link #getScore()} method will return an array of scores. The last score ({@code getScores().length - 1}),
 * is the final score. The other scores left is the array to be displayed.</p>
 *
 * <p>As such, the {@link #getScore()} method will always be a length of 3 or higher as it doesn't make sense to have
 * an array of 2 scores where both scores are the same. For example, {@code getScores()[0]} returns 42 and
 * {@code getScores()[1]} returns 42.</p>
 *
 */
public interface Game {
    /**
     * Method used to play the game.
     */
    void play();

    /**
     * Get the final score of the game.
     *
     * @return The final score
     * @throws UnsupportedOperationException Thrown when the getScores() method is to be used instead
     */
    Long getScore() throws UnsupportedOperationException;

    /**
     * <p>If the playing the game results in more than one score, this method provides them.</p>
     *
     * <p>The last index of the array is the final (or total) score. The rest of the array is the other scores. As
     * such, the array length will always be 3 ore greater.</p>
     *
     * @return An array of scores with the last index being the final score
     * @throws UnsupportedOperationException Thrown when the getScore() method is to be used instead
     */
    Long[] getScores() throws UnsupportedOperationException;
}

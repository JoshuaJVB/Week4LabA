package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;

import java.util.List;

/**
 * The service interface to the {@link Leaderboard} model.
 * @Author Ronald Chaplin
 */
public interface LeaderboardService {
    /**
     * Selects the leaderboard based on the clazz provided.
     * If a leaderboard does not exist for that clazz it is created
     * @param clazz
     * @return A {@link Leaderboard} either created or selected based off the clazz
     */
    Leaderboard getLeaderboard(String clazz);

    /**
     * Saves a new {@link Leaderboard} to the database.
     * @param leaderboard the new {@link Leaderboard}
     * @return the new {@link Leaderboard}
     */
    Leaderboard save(Leaderboard leaderboard);

    /**
     * Finds all the {@link Leaderboard Leaderboards} in the database
     * @return a list of all {@link Leaderboard Leaderboards}
     */
    Iterable<Leaderboard> getAll();

    /**
     * Returns n# of top scores from provided {@link Leaderboard}
     * @param leaderboard the {@link Leaderboard} from which {@link Match matches} are being returned
     * @param n the number of {@link Match matches} to be returned
     * @return a list of n# of {@link Match matches}
     */
    List<Match> getSome(Leaderboard leaderboard, int n);

    /**
     * Deletes the {@link Leaderboard} associated with the given Id
     * @param id the unique identifier for the {@link Leaderboard} to be deleted.
     */
    void delete(Long id);
}

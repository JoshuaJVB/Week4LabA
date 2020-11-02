package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Match;

/**
 * The service interface to the {@link Match} model.
 */
public interface MatchService {
    /**
     * Saves a new {@link Match} to the database.
     * @param match the new {@link Match}
     * @return an updated version (with id property set) of the new {@link Match}
     */
    Match create(Match match);

    /**
     * Finds all of the {@link Match Matches} in the database
     * @return a list of {@link Match Matches}
     */
    Iterable<Match> reads();

    /**
     * Finds a single {@link Match} record by the given id
     * @param id the unique record identifier
     * @return the found {@link Match} or {@code null} if none exists
     */
    Match read(Long id);

    /**
     * Updates a given match
     * @param match the updated match
     * @param id the unique record identifier
     * @return the updated match
     */
    Match update(Match match, Long id);

    /**
     * Deletes the {@link Match} associated with the given id
     * @param id the unique record identifier
     * @return the {@link Match} that was deleted or {@code null} if none was found
     */
    Match delete(Long id);

    /**
     * Deletes the given {@link Match}
     * @param match the {@link Match} to be deleted
     * @return the {@link Match} that was deleted
     */
    Match delete(Match match);
}

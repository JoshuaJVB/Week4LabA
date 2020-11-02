package com.groupa.week4laba.model;

import javax.persistence.*;

/**
 * <p>The Match entity (or table) represents one {@link com.groupa.week4laba.game.Game Game} played.</p>
 *
 * <p>The {@link #getUser() user} property is a OneToOne mapping to the {@link User} entity/table.</p>
 *
 * <p>The {@link #getLeaderboard() leaderboard} property is a ManyToMany mapping to the {@link Leaderboard}
 * entity/table.</p>
 */
@Entity(name = "Match")
public class Match implements Comparable<Match> {
    /**
     * Represents the number of top matches to be displayed on the {@link #getLeaderboard() leaderboard}.
     */
    public static final int LEADERBOARD_LENGTH = 5;

    private Long id;
    private Long score;
    private User user;
    private Leaderboard leaderboard;

    public Match(Long score, User user, Leaderboard leaderboard) {
		super();
		this.score = score;
		this.user = user;
		this.leaderboard = leaderboard;
	}

    /**
     * Default constructor used by Spring Boot. Developers should use the {@link #Match(Long, User, Leaderboard)}
     * constructor.
     */
	public Match() { }

    /**
     * A unique, generated identifier.
     * @return the id
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    /**
     * A unique, generated identifier.
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * The total score of the match.
     * @return total score
     */
    public Long getScore() {
        return score;
    }

    /**
     * The total score of the match.
     * @param score total score
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * The user playing the game. This is a OneToOne mapping to {@link User}.
     * @return the user
     */
    @OneToOne
    public User getUser() {
        return user;
    }

    /**
     * The user playing the game. This is a OneToOne mapping to {@link User}.
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * The {@link Leaderboard} for the game being played.
     * @return the game's leaderboard
     */
    @ManyToOne
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    /**
     * The {@link Leaderboard} for the game being played.
     * @param leaderboard the game's leaderboard
     */
    public void setLeaderboard(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    @Override
    public int compareTo(Match o) {
        return this.score.compareTo(o.score);
    }
}

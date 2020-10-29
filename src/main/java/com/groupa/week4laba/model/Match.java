package com.GroupA.week4laba.model;

import javax.persistence.*;

@Entity(name = "Match")
public class Match implements Comparable<Match> {
    private Long id;
    private Long score;
    private User user;
    private Leaderboard leaderboard;

    public Match(Long score, User user) {
        this.score = score;
        this.user = user;
    }
    
    public Match(Long score, User user, Leaderboard leaderboard) {
		super();
		this.score = score;
		this.user = user;
		this.leaderboard = leaderboard;
	}

	public Match() { }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(Leaderboard leaderboard) {
        this.leaderboard = leaderboard;
    }

    @Override
    public int compareTo(Match o) {
        return this.score.compareTo(o.score);
    }
}

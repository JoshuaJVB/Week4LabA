package com.GroupA.Week4LabA.model;

import javax.persistence.*;

@Entity
public class Match {
    private Long id;
    private Long score;
    private User user;

    public Match(Long score, User user) {
        this.score = score;
        this.user = user;
    }

    public Match() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}

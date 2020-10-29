package com.groupa.week4laba.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "leaderboard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matches;

    private String clazz;

    public Leaderboard(){
        super();
        this.matches = new ArrayList<>();
    }

    public Leaderboard(String clazz) {
        this();
        this.clazz = clazz;
    }

    public Long getId() {
        return id;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Column(unique = true)
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String _clazz) {
        this.clazz = _clazz;
    }
}

package com.groupa.week4laba.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue
    private Long id;

    // @JsonIgnore fixes infinite recursion StackOverflowError when 
    // making call to http://localhost:8080/admin/get/leaderboard/all
    // Not sure why this happens. I will read more about this problem (Tye)
    @JsonIgnore
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

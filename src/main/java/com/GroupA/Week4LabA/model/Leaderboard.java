package com.GroupA.Week4LabA.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lib_id;

//    @OneToMany(mappedBy = "leaderboard")
    @OneToMany
    private List<Match> matches;

    public Leaderboard(){}

    public Long getLib_id() {
        return lib_id;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}

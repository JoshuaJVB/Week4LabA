package com.GroupA.Week4LabA.Model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue
    private Long lib_id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "leaderboard", cascade = CascadeType.ALL, orphanRemoval = true)
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

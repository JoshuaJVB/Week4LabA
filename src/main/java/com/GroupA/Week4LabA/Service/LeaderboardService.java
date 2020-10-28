package com.GroupA.Week4LabA.Service;

import com.GroupA.Week4LabA.Model.Match;

import java.util.Collection;

public interface LeaderboardService {

    public Iterable<Match> getAll();

    public Iterable<Match> getSome(int n);
}

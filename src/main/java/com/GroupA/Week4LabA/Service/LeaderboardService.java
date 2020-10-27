package com.GroupA.Week4LabA.service;

import com.GroupA.Week4LabA.model.Match;

import java.util.Collection;

public interface LeaderboardService {

    public Iterable<Match> getAll();

    public Iterable<Match> getSome(int n);
}

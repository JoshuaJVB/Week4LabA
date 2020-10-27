package com.GroupA.Week4LabA.Service;

import java.util.Collection;

public interface LeaderboardService {

    public Iterable<Match> getAll();

    public Iterable<Match> getSome(int n);
}

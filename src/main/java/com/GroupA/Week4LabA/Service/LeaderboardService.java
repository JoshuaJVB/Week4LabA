package com.GroupA.Week4LabA.Service;

import com.GroupA.Week4LabA.Model.Leaderboard;

public interface LeaderboardService {

    public Iterable<Leaderboard> getAll();

    public Iterable<Leaderboard> getSome(int n);
}

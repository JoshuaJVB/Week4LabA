package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Leaderboard;

public interface LeaderboardService {

    public Iterable<Leaderboard> getAll();

    public Iterable<Leaderboard> getSome(int n);
}

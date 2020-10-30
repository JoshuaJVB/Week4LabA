package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;

import java.util.List;

public interface LeaderboardService {
    Leaderboard getLeaderboard(String clazz);

    Leaderboard save(Leaderboard leaderboard);

    Iterable<Leaderboard> getAll();

    List<Match> getSome(Leaderboard leaderboard, int n);

    void delete(Long id);
}

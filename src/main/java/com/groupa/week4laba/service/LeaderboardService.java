package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;

import java.util.List;

public interface LeaderboardService {

    Iterable<Leaderboard> getAll();

    List<Match> getSome(int n);
}

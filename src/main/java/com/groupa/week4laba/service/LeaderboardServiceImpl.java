package com.groupa.week4laba.service;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.repo.LeaderboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    final LeaderboardRepo leaderboardRepo;

    @Autowired
    public LeaderboardServiceImpl(LeaderboardRepo leaderboardRepo){
        this.leaderboardRepo = leaderboardRepo;
    }

    @Override
    public Leaderboard getLeaderboard(String clazz) {
        Leaderboard leaderboard = leaderboardRepo.findByClazz(clazz);

        if (leaderboard == null) {
            leaderboard = new Leaderboard(clazz);
        }

        return leaderboard;
    }

    @Override
    public Iterable<Leaderboard> getAll() {
        return leaderboardRepo.findAll();
    }

    @Override
    public List<Match> getSome(Leaderboard leaderboard, int n) {
        List<Match> topN = new ArrayList<>();
        if (leaderboard != null) {
            List<Match> matches = leaderboard.getMatches();
            Collections.sort(matches);
            Collections.reverse(matches);

            //Accounting for if the number of requested matches(int n) is greater than the total number of matches
            //should probably be moved to where ever int n is given by the user.
            for (int i = 0; i < Math.min(matches.size(), n); i++) {
                topN.add(matches.get(i));
            }
        }
        return topN;
    }
}

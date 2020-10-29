package com.GroupA.week4laba.repo;

import com.GroupA.week4laba.model.Leaderboard;
import com.GroupA.week4laba.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    final LeaderboardRepo leaderboardRepo;

    @Autowired
    public LeaderboardServiceImpl(LeaderboardRepo leaderboardRepo){
        this.leaderboardRepo = leaderboardRepo;
    }

    @Override
    public Iterable<Leaderboard> getAll() {
        return leaderboardRepo.findAll();
    }

    @Override
    public Iterable<Leaderboard> getSome(int n) {
        Iterable<Leaderboard> topN = leaderboardRepo.findAll();
        //Started some basic code here but then remembered we are supposed to be doing test driven
        //development and I have not created any tests yet.
        return topN;
    }
}

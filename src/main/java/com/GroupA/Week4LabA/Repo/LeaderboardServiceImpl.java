package com.GroupA.Week4LabA.repo;

import com.GroupA.Week4LabA.service.LeaderboardService;
import com.GroupA.Week4LabA.model.Match;
import org.springframework.stereotype.Service;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {

    private LeaderboardRepo leaderboardRepo;

    public LeaderboardServiceImpl(LeaderboardRepo leaderboardRepo){
        this.leaderboardRepo = leaderboardRepo;
    }

    @Override
    public Iterable<Match> getAll() {
        return leaderboardRepo.findAll();
    }

    @Override
    public Iterable<Match> getSome(int n) {
        Iterable<Match> topN = leaderboardRepo.findAll();
        //Started some basic code here but then remembered we are supposed to be doing test driven
        //development and I have not created any tests yet.
        return topN;
    }
}

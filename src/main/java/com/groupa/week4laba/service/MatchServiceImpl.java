package com.GroupA.week4laba.service;

import com.GroupA.week4laba.model.Match;
import com.GroupA.week4laba.repo.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    final MatchRepo matchRepo;

    @Autowired
    public MatchServiceImpl(MatchRepo matchRepo) {
        this.matchRepo = matchRepo;
    }

    @Override
    public Match create(Match match) {
        return matchRepo.save(match);
    }

    @Override
    public Iterable<Match> reads() {
        return matchRepo.findAll();
    }

    @Override
    public Match read(Long id) {
        return matchRepo.findById(id).isPresent() ?  matchRepo.findById(id).get() : null;
    }

    @Override
    public Match update(Match match, Long id) {
        Match newMatch = matchRepo.findById(id).isPresent() ?  matchRepo.findById(id).get() : null;
        if (newMatch == null) return null;

        newMatch.setScore(match.getScore());
        newMatch.setUser(match.getUser());

        return matchRepo.save(newMatch);
    }

    @Override
    public Match delete(Long id) {
        Match match = matchRepo.findById(id).isPresent() ?  matchRepo.findById(id).get() : null;
        return delete(match);
    }

    @Override
    public Match delete(Match match) {
        if (match != null) matchRepo.delete(match);
        return match;
    }
}

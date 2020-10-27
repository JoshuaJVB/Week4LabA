package com.GroupA.Week4LabA.service;

import com.GroupA.Week4LabA.model.Match;

public interface MatchService {
    Match create(Match match);
    Iterable<Match> reads();
    Match read(Long id);
    Match update(Match match, Long id);
    Match delete(Long id);
    Match delete(Match match);
}

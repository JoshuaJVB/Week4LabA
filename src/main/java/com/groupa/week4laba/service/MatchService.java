package com.GroupA.week4laba.service;

import com.GroupA.week4laba.model.Match;

public interface MatchService {
    Match create(Match match);
    Iterable<Match> reads();
    Match read(Long id);
    Match update(Match match, Long id);
    Match delete(Long id);
    Match delete(Match match);
}

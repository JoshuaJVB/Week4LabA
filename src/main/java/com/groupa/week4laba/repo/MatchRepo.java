package com.GroupA.week4laba.repo;

import com.GroupA.week4laba.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends CrudRepository<Match, Long> {
}

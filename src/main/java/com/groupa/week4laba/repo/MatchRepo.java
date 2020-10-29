package com.groupa.week4laba.repo;

import com.groupa.week4laba.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends CrudRepository<Match, Long> {
}

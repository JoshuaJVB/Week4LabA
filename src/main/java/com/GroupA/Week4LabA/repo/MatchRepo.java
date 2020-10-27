package com.GroupA.Week4LabA.repo;

import com.GroupA.Week4LabA.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends CrudRepository<Match, Long> {
}

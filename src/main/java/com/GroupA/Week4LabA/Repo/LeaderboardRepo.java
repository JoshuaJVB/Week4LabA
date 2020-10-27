package com.GroupA.Week4LabA.Repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends CrudRepository<Match, Long> {
}

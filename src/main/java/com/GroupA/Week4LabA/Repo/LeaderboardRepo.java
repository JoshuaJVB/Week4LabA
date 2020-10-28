package com.GroupA.Week4LabA.Repo;


import com.GroupA.Week4LabA.Model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends CrudRepository<Match, Long> {
}

package com.GroupA.Week4LabA.Repo;


import com.GroupA.Week4LabA.Model.Leaderboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends CrudRepository<Leaderboard, Long> {
}

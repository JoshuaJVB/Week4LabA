package com.GroupA.week4laba.repo;

import com.GroupA.week4laba.model.Leaderboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends CrudRepository<Leaderboard, Long> {
}

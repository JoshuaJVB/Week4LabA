package com.groupa.week4laba.repo;

import com.groupa.week4laba.model.Leaderboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderboardRepo extends CrudRepository<Leaderboard, Long> {
    Leaderboard findByClazz(String clazz);
}

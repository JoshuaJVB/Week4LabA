package com.GroupA.Week4LabA.Service;

import com.GroupA.Week4LabA.Model.Leaderboard;
import com.GroupA.Week4LabA.Model.Match;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface LeaderboardService {

    Iterable<Leaderboard> getAll();

    List<Match> getSome(int n);
}

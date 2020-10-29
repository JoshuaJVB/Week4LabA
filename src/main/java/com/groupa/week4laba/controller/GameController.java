package com.groupa.week4laba;

import com.groupa.week4laba.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    final LeaderboardService leaderboardService;

    @Autowired
    public GameController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/")
    void root() {
        
    }
}

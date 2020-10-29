package com.groupa.week4laba.controller;

import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.Random;
import com.groupa.week4laba.game.SnakeEyes;
import com.groupa.week4laba.game.TriScore;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.repo.LeaderboardRepo;
import com.groupa.week4laba.repo.MatchRepo;
import com.groupa.week4laba.repo.UserRepo;
import com.groupa.week4laba.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {
    private final LeaderboardService leaderboardService;
    private final UserRepo userRepo;
    private final MatchRepo matchRepo;
    private final LeaderboardRepo leaderboardRepo;
    private final Leaderboard[] leaderboards = new Leaderboard[3];

    @Autowired
    public GameController(LeaderboardService leaderboardService, UserRepo userRepo, MatchRepo matchRepo, LeaderboardRepo leaderboardRepo) {
        this.leaderboardService = leaderboardService;
        this.userRepo = userRepo;
        this.matchRepo = matchRepo;
        this.leaderboardRepo = leaderboardRepo;
        leaderboards[0] = leaderboardService.getLeaderboard("com.group.week4laba.game.SnakeEyes");
        leaderboards[1] = leaderboardService.getLeaderboard("com.group.week4laba.game.TriScore");
        leaderboards[2] = leaderboardService.getLeaderboard("com.group.week4laba.game.Random");
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/")
    public ModelAndView postIndex(@ModelAttribute String clazz) {
        ModelAndView modelAndView = new ModelAndView();

        switch (clazz) {
            case "com.group.week4laba.game.SnakeEyes":
                modelAndView.setViewName("SnakeEyes");
                modelAndView.addObject("leaderboard", leaderboards[0]);
                return modelAndView;
            case "com.group.week4laba.game.TriScore":
                modelAndView.setViewName("TriScore");
                modelAndView.addObject("leaderboard", leaderboards[1]);
                return modelAndView;
            case "com.group.week4laba.game.Random":
                modelAndView.setViewName("Random");
                modelAndView.addObject("leaderboard", leaderboards[1]);
                return modelAndView;
            default:
                modelAndView.setViewName("index");
                return modelAndView;
        }
    }

    @PostMapping("/SnakeEyes")
    public ModelAndView postSnakeEyes(@ModelAttribute Leaderboard leaderboard) {
        Game game = new SnakeEyes();
        game.play();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PostSnakeEyes");
        modelAndView.addObject("score", game.getScore());
        modelAndView.addObject("leaderboard", leaderboard);
        modelAndView.addObject("topMatches", leaderboardService.getSome(leaderboard, game.getLeaderboardLength()));
        return modelAndView;
    }

    @PostMapping("/TriScore")
    public ModelAndView postTriScore(@ModelAttribute Leaderboard leaderboard) {
        Game game = new TriScore();
        game.play();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PostTriScore");
        modelAndView.addObject("scores", game.getScores());
        modelAndView.addObject("leaderboard", leaderboard);
        modelAndView.addObject("topMatches", leaderboardService.getSome(leaderboard, game.getLeaderboardLength()));
        return modelAndView;
    }

    @PostMapping("/Random")
    public ModelAndView postRandom(@ModelAttribute Leaderboard leaderboard) {
        Game game = new Random();
        game.play();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("PostRandom");
        modelAndView.addObject("score", game.getScore());
        modelAndView.addObject("leaderboard", leaderboard);
        modelAndView.addObject("topMatches", leaderboardService.getSome(leaderboard, game.getLeaderboardLength()));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView postUpdate(@ModelAttribute Leaderboard leaderboard, @ModelAttribute String username, @ModelAttribute Long score) {
        User user = new User(username);
        user = userRepo.save(user);
        Match match = new Match(score, user, leaderboard);
        match = matchRepo.save(match);

        leaderboard.getMatches().add(match);
        leaderboard = leaderboardRepo.save(leaderboard);

        switch (leaderboard.getClazz()) {
            case "com.group.week4laba.game.SnakeEyes":
                leaderboards[0] = leaderboard;
            case "com.group.week4laba.game.TriScore":
                leaderboards[1] = leaderboard;
            case "com.group.week4laba.game.Random":
                leaderboards[2] = leaderboard;
        }

        return postIndex(leaderboard.getClazz());
    }
}

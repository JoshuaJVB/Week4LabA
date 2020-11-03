package com.groupa.week4laba.controller;

import java.util.Optional;
import java.util.List;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.service.LeaderboardServiceImpl;
import com.groupa.week4laba.service.MatchServiceImpl;
import com.groupa.week4laba.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // =========================================================
    // Injected Properties
    // =========================================================

    private final MatchServiceImpl matchService;
    private final UserServiceImpl userService;
    private final LeaderboardServiceImpl leaderboardService;

    // =========================================================
    // Constructor
    // =========================================================

    @Autowired
    public AdminController(MatchServiceImpl matchService, UserServiceImpl userService, LeaderboardServiceImpl leaderboardService) {
        this.matchService = matchService;
        this.userService = userService;
        this.leaderboardService = leaderboardService;
    }
    
    // =========================================================
    // GET Admin Mapping
    // =========================================================

    // User 
    @GetMapping("/get/user/{byId}")
    public Optional<User> getUser(@PathVariable Long byId) {
        return userService.getUserById(byId);
    }

    @GetMapping("/get/user/all")
    public Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    // Match 
    @GetMapping("/get/match/{byId}")
    public Optional<Match> getMatch(@PathVariable Long byId) {
        return Optional.of(matchService.read(byId));
    }

    @GetMapping("/get/match/all")
    public Iterable<Match> getMatches() {
        return matchService.reads();
    }

    // Leaderboard 
    @GetMapping("/get/leaderboard/{byClazz}")
    public Leaderboard getLeaderboard(@PathVariable String byClazz) {
        return leaderboardService.getLeaderboard(byClazz);
    }

    @GetMapping("/get/leaderboard/{byClazz}/{numberOfMatches}")
    public List<Match> getLeaderboard(@PathVariable String byClazz, @PathVariable int numberOfMatches) {
        return leaderboardService.getSome(leaderboardService.getLeaderboard(byClazz), numberOfMatches);
    }

    @GetMapping("/get/leaderboard/all")
    public Iterable<Leaderboard> getLeaderboards() {
        return leaderboardService.getAll();
    }


    // =========================================================
    // POST Admin Mapping
    // =========================================================

    @PostMapping("/post/user")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User (" + user.getUsername() + ") saved...";
    }

    @PostMapping("/post/match")
    public String saveMatch(@RequestBody Match match) {
        matchService.create(match);
        return "Match with id (" + match.getId() + ") saved...";
    }

    @PostMapping("/post/leaderboard")
    public String saveLeaderboard(@RequestBody Leaderboard leaderboard) {
        leaderboardService.save(leaderboard);
        return "Leaderboard with clazz (" + leaderboard.getClazz() + ") saved...";
    }

    // =========================================================
    // DELETE Admin Mapping
    // =========================================================

    @DeleteMapping("/delete/user/{byId}")
    public String deleteUser(@PathVariable Long byId) {
        userService.removeUserById(byId);
        return "User with id (" + byId + ") removed...";
    }

    @DeleteMapping("/delete/match/{byId}")
    public String deleteMatch(@PathVariable Long byId) {
        matchService.delete(byId);
        return "Match with id (" + byId + ") removed...";
    }

    @DeleteMapping("/delete/leaderboard/{byId}")
    public String deleteLeaderboard(@PathVariable Long byId) {
        leaderboardService.delete(byId);
        return "Leaderboard with id (" + byId + ") removed...";
    }
    
}

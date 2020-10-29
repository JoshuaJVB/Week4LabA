package com.groupa.week4laba.controller;

import com.groupa.week4laba.service.MatchServiceImpl;
import com.groupa.week4laba.service.UserServiceImpl;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.repo.LeaderboardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatchController {

	@Autowired
	private MatchServiceImpl matchService;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private LeaderboardServiceImpl leaderboardService;

	Integer signedInUserId;

	// =========================================================
    // GET
    // =========================================================

	@GetMapping("/match/{id}")
	public Match fetch(@PathVariable Long matchId) {
		return this.matchService.read(matchId);
	}

	@GetMapping("/match/all")
	public Iterable<Match> fetchAll() {
		return this.matchService.reads();
	}

	// =========================================================
    // POST
    // =========================================================

	@PostMapping("/match")
	public String create(@RequestBody Match match) {
		this.matchService.create(match);
		return "Created Match";
	}

	@RequestMapping("/signIn") 
	public String submitSignInForm(@RequestParam(value = "username", required = true) String username) {
		this.signedInUserId = null;
		User fetchedUser = userService.getUserByUsername(username);
		if ( !(fetchedUser == null) ) {
			this.signedInUserId = fetchedUser.getUserId().intValue();
		} else {
			this.signedInUserId = userService.saveUser(new User(username)).getUserId().intValue();
		}
		return "match";
	}

	// =========================================================
    // PUT
    // =========================================================

	@PutMapping("/match/update/{id}")
	public String update(@RequestBody Match newMatchVersion, @PathVariable Long id) {
		this.matchService.update(newMatchVersion, id);
		return "Match with id (" + id + ") updated";
	}

	// =========================================================
    // DELETE
    // =========================================================

    @DeleteMapping("/match/delete")
    public String remove(@RequestBody Match match) {
    	this.matchService.delete(match);
    	return "Match with id (" + match.getId() + ") removed.";
    }

    @DeleteMapping("/match/delete")
    public String removeById(@PathVariable Long id) {
    	this.matchService.delete(id);
    	return "Match with id (" + id + ") removed.";
    }

}
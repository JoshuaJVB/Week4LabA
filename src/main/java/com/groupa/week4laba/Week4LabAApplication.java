package com.groupa.week4laba;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.repo.LeaderboardRepo;
import com.groupa.week4laba.repo.MatchRepo;
import com.groupa.week4laba.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Week4LabAApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week4LabAApplication.class, args);
	}

	@Bean
	public CommandLineRunner gameDemo(MatchRepo matchRepo, UserRepo userRepo, LeaderboardRepo leaderboardRepo) {
		return (args) -> {
			User user = new User("blaztek");
			user.setScore(512256128L);
			user = userRepo.save(user);
			Match match = new Match(512256128L, user);
			match = matchRepo.save(match);
			Long matchId = match.getId();

			match = matchRepo.findById(matchId).isPresent() ? matchRepo.findById(matchId).get() : null;
			if (match != null) {
				System.out.println("##################");
				System.out.println(match.getUser().getUsername() + ": " + match.getScore());
				System.out.println("##################");
			}

			Leaderboard leaderboard = new Leaderboard();
			leaderboardRepo.save(leaderboard);
			
			List<Match> matches = new ArrayList<>();
			match.setLeaderboard(leaderboard);
			matches.add(match);
			match = new Match(1000L, user, leaderboard);
			matchRepo.save(match);
			matches.add(match);
			match = new Match(2000L, user, leaderboard);
			matchRepo.save(match);
			matches.add(match);
			match = new Match(3000L, user, leaderboard);
			matchRepo.save(match);
			matches.add(match);
			match = new Match(4000L, user, leaderboard);
			matchRepo.save(match);
			matches.add(match);
			match = new Match(5000L, user, leaderboard);
			matchRepo.save(match);
			matches.add(match);

			leaderboard.setMatches(matches);
			leaderboard = leaderboardRepo.save(leaderboard);

			
			System.out.println(leaderboard.getId());
			leaderboard = leaderboardRepo.findById(leaderboard.getId()).isPresent() ? leaderboardRepo.findById(leaderboard.getId()).get() : null;
			if (leaderboard != null) {
				matches = leaderboard.getMatches();
				Collections.sort(matches);
				Collections.reverse(matches);

				int length = matches.size() > 5 ? 5 : matches.size();
				for (int i = 0; i < length; i++) {
					match = matches.get(i);
					System.out.println("#" + (i + 1) + ": " + match.getUser().getUsername() + "\t" + match.getScore());
				}
			}
		};
	}
}

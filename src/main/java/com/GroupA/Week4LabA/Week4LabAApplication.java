package com.GroupA.Week4LabA;

import com.GroupA.Week4LabA.Model.Leaderboard;
import com.GroupA.Week4LabA.Model.Match;
import com.GroupA.Week4LabA.Model.User;
import com.GroupA.Week4LabA.Repo.LeaderboardRepo;
import com.GroupA.Week4LabA.Repo.MatchRepo;
import com.GroupA.Week4LabA.Repo.UserRepo;
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

			
			System.out.println(leaderboard.getLib_id());
			leaderboard = leaderboardRepo.findById(leaderboard.getLib_id()).isPresent() ? leaderboardRepo.findById(leaderboard.getLib_id()).get() : null;
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

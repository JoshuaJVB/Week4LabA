package com.groupa.week4laba;

import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.SnakeEyes;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.service.LeaderboardService;
import com.groupa.week4laba.service.MatchService;
import com.groupa.week4laba.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Week4LabAApplication {
	private static final String gameId = "com.group.week4laba.game.SnakeEyes";


	public static void main(String[] args) {
		SpringApplication.run(Week4LabAApplication.class, args);
	}

	// TODO: Remember to delete all of the code below before testing GameController

	// @Bean
	// public CommandLineRunner gameDemo(MatchService matchService, UserService userService, LeaderboardService leaderboardService) {
	// 	return (args) -> {
	// 		playGame("blaztek", leaderboardService, matchService, userService);
	// 		playGame("jackstraw", leaderboardService, matchService, userService);
	// 		playGame("blaztek", leaderboardService, matchService, userService);
	// 		playGame("ststephen", leaderboardService, matchService, userService);
	// 		playGame("blaztek", leaderboardService, matchService, userService);
	// 		playGame("caseyjones", leaderboardService, matchService, userService);

	// 		Leaderboard leaderboard = leaderboardService.getLeaderboard(gameId);
	// 		List<Match> topN = leaderboardService.getSome(leaderboard, Game.LEADERBOARD_LENGTH);

	// 		printLeaderboard(topN);
	// 	};
	// }

	// private void playGame(String username, LeaderboardService leaderboardService, MatchService matchService, UserService userService) {
	// 	Leaderboard leaderboard = leaderboardService.getLeaderboard(gameId);
	// 	List<Match> matches = leaderboard.getMatches();
	// 	User user = userService.getUserByUsername(username);

	// 	Game game = new SnakeEyes();
	// 	game.play();

	// 	user.setScore(game.getScore());
	// 	user = userService.saveUser(user);

	// 	Match match = new Match(game.getScore(), user, leaderboard);
	// 	match = matchService.create(match);
	// 	matches.add(match);

	// 	System.out.printf("%10s scored: %d%n", username, match.getScore());
	// }

	// private void printLeaderboard(List<Match> matches) {
	// 	System.out.println("############");
	// 	System.out.println(" Snake Eyes");
	// 	System.out.println("############");

	// 	int index = 1;

	// 	for (Match match : matches) {
	// 		System.out.printf("#%d: %10s\t%d%n", index++, match.getUser().getUsername(), match.getScore());
	// 	}
	// }


//	@Bean
//	public CommandLineRunner gameDemo(MatchRepo matchRepo, UserRepo userRepo, LeaderboardRepo leaderboardRepo) {
//		return (args) -> {
//			User user = new User("blaztek");
//			user.setScore(512256128L);
//			user = userRepo.save(user);
//			Match match = new Match(512256128L, user);
//			match = matchRepo.save(match);
//			Long matchId = match.getId();
//
//			match = matchRepo.findById(matchId).orElse(null);
//			if (match != null) {
//				System.out.println("##################");
//				System.out.println(match.getUser().getUsername() + ": " + match.getScore());
//				System.out.println("##################");
//			} else {
//				System.err.println("Unexplained error occurred.");
//				return;
//			}
//
//			Leaderboard leaderboard = new Leaderboard();
//			leaderboard = leaderboardRepo.save(leaderboard);
//
//			List<Match> matches = new ArrayList<>();
//			match.setLeaderboard(leaderboard);
//			matches.add(match);
//			match = new Match(1000L, user, leaderboard);
//			matchRepo.save(match);
//			matches.add(match);
//			match = new Match(2000L, user, leaderboard);
//			matchRepo.save(match);
//			matches.add(match);
//			match = new Match(3000L, user, leaderboard);
//			matchRepo.save(match);
//			matches.add(match);
//			match = new Match(4000L, user, leaderboard);
//			matchRepo.save(match);
//			matches.add(match);
//			match = new Match(5000L, user, leaderboard);
//			matchRepo.save(match);
//			matches.add(match);
//
//			leaderboard.setMatches(matches);
//			leaderboard = leaderboardRepo.save(leaderboard);
//
//			System.out.println(leaderboard.getId());
//
//			System.out.println("##################");
//			System.out.println("##### TOP 5 ######");
//			System.out.println("##################");
//			leaderboard = leaderboardRepo.findById(leaderboard.getId()).orElse(null);
//			if (leaderboard != null) {
//				matches = leaderboard.getMatches();
//				Collections.sort(matches);
//				Collections.reverse(matches);
//
//				int length = Math.min(matches.size(), 5);
//				for (int i = 0; i < length; i++) {
//					match = matches.get(i);
//					System.out.println("#" + (i + 1) + ": " + match.getUser().getUsername() + "\t" + match.getScore());
//				}
//			}
//		};
//	}
}

package com.GroupA.Week4LabA;

import com.GroupA.Week4LabA.model.Match;
import com.GroupA.Week4LabA.model.User;
import com.GroupA.Week4LabA.repo.MatchRepo;
import com.GroupA.Week4LabA.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week4LabAApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week4LabAApplication.class, args);
	}

	@Bean
	public CommandLineRunner gameDemo(MatchRepo matchRepo, UserRepo userRepo) {
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
		};
	}
}

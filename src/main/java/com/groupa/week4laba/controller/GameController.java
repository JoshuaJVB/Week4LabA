package com.groupa.week4laba.controller;

import com.groupa.week4laba.service.MatchServiceImpl;
import com.groupa.week4laba.service.UserServiceImpl;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.service.LeaderboardServiceImpl;
import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.SnakeEyes;
import com.groupa.week4laba.game.TriScore;
import com.groupa.week4laba.game.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/***********************************************************
 * GameController is responsible for mutating data on the  
 * server and giving a proper response to the user based on
 * user input
 *
 * @author  Tye Porter (github.com/tyeporter)
 * @version 0.1
 * @since   10-28-2020
 ***********************************************************/

@Controller
public class GameController {

    // =========================================================
    // Autowired Properties
    // =========================================================
    @Autowired
    private MatchServiceImpl matchService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private LeaderboardServiceImpl leaderboardService;


    // =========================================================
    // Properties
    // =========================================================
    Long signedInUserId;
    String gameChoice;
    Long userScore;


    // =========================================================
    // GET
    // =========================================================

    /***********************************************************
     * GET endpoint that corresponds to the login view.
     * 
     * This method is responsible for passing a new {@code User} 
     * to the {@code /login} Thymeleaf view model
     *
     * @param model The Thymeleaf view model for the 
     * {@code /login} endpoint
     ***********************************************************/
    @GetMapping("/login")
    public String showLogin(Model model) {
        signedInUserId = null;
        gameChoice = null;
        userScore = null;
        model.addAttribute("user", new User());
        return "login";
    }

    /***********************************************************
     * GET endpoint that corresponds to the play / game view.
     * 
     * This method is responsible for passing the  {@code Game} 
     * and the {@code Leaderboard} to the {@code /play} 
     * Thymeleaf view model
     *
     * @param model The Thymeleaf view model for the 
     * {@code /play} endpoint
     ***********************************************************/
    @GetMapping("/play")
    public String showGame(Model model) {
        Leaderboard leaderboard = leaderboardService.getLeaderboard("com.group.week4laba.game." + this.gameChoice);
        model.addAttribute("game", this.gameChoice);
        model.addAttribute("leaderboard", leaderboardService.getSome(leaderboard, 5));
        return "play";
    }

    /***********************************************************
     * GET endpoint that corresponds to the results view.
     * 
     * This method is responsible for passing the updated 
     * {@code Game} with {@code User} score
     * and the updated {@code Leaderboard} to the 
     * {@code /results} Thymeleaf view model
     *
     * @param model The Thymeleaf view model for the 
     * {@code /results} endpoint
     ***********************************************************/
    @GetMapping("/results")
    public String showResults(Model model) {
        Leaderboard leaderboard = leaderboardService.getLeaderboard("com.group.week4laba.game." + this.gameChoice);
        model.addAttribute("userScore", this.userScore);
        model.addAttribute("leaderboard", leaderboardService.getSome(leaderboard, 5));
        return "results";
    }


    // =========================================================
    // POST
    // =========================================================

    /***********************************************************
     * POST endpoint that corresponds to the login view's form
     * submission.
     * 
     * This method takes in a {@code User} and checks to see
     * if that {@code User} is already in the database. If not,
     * a new {@code User} will be created. 
     * 
     * The  Thymeleaf view for the {@code /pickGame} endpoint will 
     * be presented to the {@code User}
     *
     * @param user The Thymeleaf model attribute that corresponds 
     * to the {@code User} that logged in
     ***********************************************************/
    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") User user) {
        User fetchedUser = userService.getUserByUsername(user.getUsername());

        if (fetchedUser != null) {
            this.signedInUserId = fetchedUser.getUserId();
        } else {
            this.signedInUserId = userService.saveUser(new User(user.getUsername())).getUserId();
        }

        System.out.println(user.getUsername() + " logged in");
        return "pick_game";
    }

    /***********************************************************
     * POST endpoint that corresponds to the pick game view's 
     * form submission.
     * 
     * This method takes in a {@code String} value that
     * represents the type of game the {@code User} wants to 
     * play. To track the {@code User}'s game choice,
     * the {@code String} is stored locally.
     * 
     * It will then redirect the user to the {@code /play}
     * endpoint
     *
     * @param game The Thymeleaf model attribute that corresponds 
     * to the games selected by the user
     ***********************************************************/
    @PostMapping("/pickGame")
    public String pickGame(@ModelAttribute("game") String game) {
        System.out.println(game);
        this.gameChoice = game;
        return "redirect:/play";
    }

    /***********************************************************
     * POST endpoint that corresponds to the play view's 
     * form submission.
     * 
     * This method is responsible for creating new {@code Game}
     * object, playing the {@code Game}, creating a new 
     * {@code Match} object based off of the {@code User}
     * and the {@code User}'s score, and updating the 
     * {@code Leaderboard} based off of the {@code Match}.
     * 
     * It will redirect the user to the {@code /results}
     * endpoint
     ***********************************************************/
    @PostMapping("/play")
    public String pressedPlay() {
        Leaderboard leaderboard = leaderboardService.getLeaderboard(this.gameChoice);
        Game game;
        Match match;

        switch (this.gameChoice) {
            case "SnakeEyes":
                game = new SnakeEyes();
                break;
            case "TriScore":
                game = new TriScore();
                break;
            case "Random":
                game = new Random();
                break;
            default:
                System.out.println("Invalid games choice... Defaulting to Random game");
                game = new Random();
                break;
        }

        game.play();
        userScore = game.getScore();
        match = matchService.create(new Match(userScore, userService.getUserById(this.signedInUserId), leaderboard));
        leaderboard.getMatches().add(match);

        return "results";
    }

    /***********************************************************
     * POST endpoint that corresponds to the results view's 
     * form submission.
     * 
     * This method is simply redirects the {@code User}
     * to the endpoint that corresponds to the submit 
     * button that they've chose.
     ***********************************************************/
    @PostMapping("/results")
    public String endGame(@ModelAttribute("endGameChoice") String endGameChoice) {
        String redirect;
        switch (endGameChoice) {
            case "PlayAgain":
                redirect = "redirect:/play";
                break;
            case "OtherGame":
                redirect = "pick_game";
                break;
            case "SignOut":
                redirect = "redirect:/login";
                break;
            default:
                redirect = "invalid_selection";
                break;
        }
        return redirect;
    }

}
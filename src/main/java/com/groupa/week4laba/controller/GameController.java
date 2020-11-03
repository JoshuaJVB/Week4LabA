package com.groupa.week4laba.controller;

import com.groupa.week4laba.service.MatchServiceImpl;
import com.groupa.week4laba.service.UserServiceImpl;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import com.groupa.week4laba.service.LeaderboardServiceImpl;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestMapping;

/***********************************************************
 * <p>{@code GameController} is responsible for mutating data on the
 * server and giving a proper response to the user based on
 * user input
 *
 * @author  Tye Porter (github.com/tyeporter)
 * @version 0.1
 * @since   10-28-2020
 ***********************************************************/

@Controller
@RequestMapping("")
public class GameController {

    // =========================================================
    // Injected Properties
    // =========================================================

    private final MatchServiceImpl matchService;
    private final UserServiceImpl userService;
    private final LeaderboardServiceImpl leaderboardService;


    // =========================================================
    // Properties
    // =========================================================

    String signedInUserUsername;
    String gameChoice;
    Long userScore;


    // =========================================================
    // Constructor
    // =========================================================

    @Autowired
    public GameController(MatchServiceImpl matchService, UserServiceImpl userService, LeaderboardServiceImpl leaderboardService) {
        this.signedInUserUsername = "guest";
        this.gameChoice = "Random";
        this.userScore = 0L;
        this.matchService = matchService;
        this.userService = userService;
        this.leaderboardService = leaderboardService;
    }


    // =========================================================
    // GET Mappings
    // =========================================================

    /***********************************************************
     * GET endpoint that corresponds to the login.html view
     * 
     * <p>This method is responsible for passing a new {@code User}
     * to the {@code /login} Thymeleaf view model.
     *
     * @param model The Thymeleaf view model for the 
     * {@code /login} endpoint
     * @return the login_page web page
     ***********************************************************/
    @GetMapping({"/login", "/"})
    public String showLogin(Model model) {
        this.resetAllValues();
        model.addAttribute("user", new User());
        return "login_page";
    }

    /***********************************************************
     * GET endpoint that corresponds to the pick_game.html view
     * 
     * <p>This method is responsible for passing the logged in
     * {@code User} to the {@code /login} Thymeleaf view model.
     *
     * @param model The Thymeleaf view model for the 
     * {@code /login} endpoint
     * @return the pick_game web page
     ***********************************************************/
    @GetMapping("/pickGame")
    public String showGameChoices(Model model) {
        this.resetGameChoice();
        model.addAttribute("user", userService.getUserByUsername(this.signedInUserUsername));
        model.addAttribute("games", Arrays.asList("Snake Eyes", "Tri Score", "Random"));
        return "pick_game";
    }

    /***********************************************************
     * GET endpoint that corresponds to the play.html view
     * 
     * <p>This method is responsible for passing the {@code Game}
     * and the {@code Leaderboard} to the {@code /play} 
     * Thymeleaf view model.
     *
     * @param model The Thymeleaf view model for the 
     * {@code /play} endpoint
     * @return the play_game web page
     ***********************************************************/
    @GetMapping("/play")
    public String showGame(Model model) {
        this.resetScore();
        Leaderboard leaderboard = leaderboardService.getLeaderboard(this.getGameChoiceClazz());
        model.addAttribute("game", this.gameChoice);
        model.addAttribute("leaderboard", leaderboardService.getSome(leaderboard, Match.LEADERBOARD_LENGTH));
        return "play_game";
    }

    /***********************************************************
     * GET endpoint that corresponds to the results.html view.
     * 
     * <p>This method is responsible for passing the updated
     * {@code Game} with {@code User} score
     * and the updated {@code Leaderboard} to the 
     * {@code /results} Thymeleaf view model.
     *
     * @param model The Thymeleaf view model for the 
     * {@code /results} endpoint
     * @return the game's results page
     ***********************************************************/
    @GetMapping("/results")
    public String showResults(Model model) {
        Leaderboard leaderboard = leaderboardService.getLeaderboard(this.getGameChoiceClazz());
        model.addAttribute("userScore", this.userScore);
        model.addAttribute("leaderboard", leaderboardService.getSome(leaderboard, Match.LEADERBOARD_LENGTH));
        model.addAttribute("actions", Arrays.asList("Play Again", "Choose Game", "Log Out"));
        return "results_page";
    }
    

    // =========================================================
    // POST Mappings
    // =========================================================

    /***********************************************************
     * POST endpoint that corresponds to the login view's form
     * submission.
     * 
     * <p>This method takes in a {@code User} and checks to see
     * if that {@code User} is already in the database. If not,
     * a new {@code User} will be created.
     * 
     * <p>The Thymeleaf view for the {@code /pickGame} endpoint will
     * be presented to the {@code User}.
     *
     * @param user The Thymeleaf model attribute that corresponds 
     * to the {@code User} that logged in
     * @return A redirect to the /pickgame GET mapping
     ***********************************************************/
    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") User user) {
        User fetchedUser = userService.getUserByUsername(user.getUsername());
        this.signedInUserUsername = fetchedUser.getUsername();

        System.out.println(this.signedInUserUsername + " logged in");
        return "redirect:/pickGame";
    }

    /***********************************************************
     * POST endpoint that corresponds to the pick game view's
     * form submission
     * 
     * <p>This method takes in a {@code String} value that
     * represents the type of game the {@code User} wants to 
     * play. To track the {@code User}'s game choice,
     * the {@code String} is stored locally.
     * 
     * <p>It will then redirect the user to the {@code /play}
     * endpoint.
     *
     * @param game The Thymeleaf model attribute that corresponds 
     * to the games selected by the user
     * @return Redirect to the /play GET mapping
     ***********************************************************/
    @PostMapping("/pickGame")
    public String pickGame(@ModelAttribute("game") String game) {
        System.out.println("Playing " + game + "...");
        this.gameChoice = game;
        return "redirect:/play";
    }

    /***********************************************************
     * POST endpoint that corresponds to the play view's
     * form submission
     * 
     * <p>This method is responsible for creating new {@code Game}
     * object, playing the {@code Game}, creating a new 
     * {@code Match} object based off of the {@code User}
     * and the {@code User}'s score, and updating the 
     * {@code Leaderboard} based off of the {@code Match}.
     * 
     * <p>It will redirect the user to the {@code /results}
     * endpoint.
     * 
     * @return A redirect to the /results GET mapping
     ***********************************************************/
    @PostMapping("/play")
    public String pressedPlay() {
        User user = userService.getUserByUsername(this.signedInUserUsername);
        Leaderboard leaderboard = leaderboardService.getLeaderboard(this.getGameChoiceClazz());
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
                System.out.println("Invalid game choice... Defaulting to Random game");
                game = new Random();
                break;
        }

        game.play();
        userScore = game.getScore();
        user.setScore(userScore);
        user = this.userService.saveUser(user);
        match = matchService.create(new Match(userScore, user, leaderboard));
        leaderboard.getMatches().add(match);

        return "redirect:/results";
    }

    /***********************************************************
     * POST endpoint that corresponds to the results view's
     * form submission.
     * 
     * <p>This method is simply redirects the {@code User}
     * to the endpoint that corresponds to the submit 
     * button that they've chose.
     * 
     * @param endGameChoice One of "PlayAgain", "ChooseGame", 
     * or "Logout"
     * @return A redirect to the proper view
     ***********************************************************/
    @PostMapping("/results")
    public String endGame(@ModelAttribute("endGameChoice") String endGameChoice) {
        String redirect;
        switch (endGameChoice) {
            case "PlayAgain":
                redirect = "redirect:/play";
                this.resetScore();
                break;
            case "ChooseGame":
                redirect = "redirect:/pickGame";
                this.resetScore();
                break;
            case "LogOut":
                redirect = "redirect:/login";
                break;
            default:
                redirect = "404";
                break;
        }
        return redirect;
    }


    // =========================================================
    // HELPER METHODS
    // =========================================================

    private String getGameChoiceClazz() {
        return "com.group.week4laba.game." + this.gameChoice;
    }   

    private void resetAllValues() {
        this.signedInUserUsername = "guest";
        this.gameChoice = "Random";
        this.userScore = 0L;
    }

    private void resetGameChoice() {
        this.gameChoice = "Random";
    }

    private void resetScore() {
        this.userScore = 0L;
    }

}
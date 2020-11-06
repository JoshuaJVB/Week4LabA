package com.groupa.week4laba.cucumber;

import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.SnakeEyes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SnakeEyesGameStepdefs {
    Game game;
    Long score;

    @Given("I want to play SnakeEyes")
    public void iWantToPlaySnakeEyes() {
        game = new SnakeEyes();
    }

    @When("I play the SnakeEyes game")
    public void iPlayTheSnakeEyesGame() {
        game.play();
        score = game.getScore();
    }

    @Then("the SnakeEyes score should be greater than or equal to {long}")
    public void theSnakeEyesScoreShouldBeGreaterThanOrEqualTo(Long arg0) {
        Assertions.assertTrue(score >= arg0);
    }

    @Then("there will be no SnakeEyes scores")
    public void thereWillBeNoSnakeEyesScores() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            game.getScores();
        });
    }

    @And("less than or equal to {long}")
    public void lessThanOrEqualTo(Long arg0) {
        Assertions.assertTrue(score <= arg0);
    }
}

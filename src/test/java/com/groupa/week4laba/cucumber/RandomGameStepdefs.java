package com.groupa.week4laba.cucumber;

import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.Random;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RandomGameStepdefs {
    Game game;
    Long score;

    @Given("I want to play Random")
    public void iWantToPlayRandom() {
        game = new Random();
    }

    @When("I play the Random game")
    public void iPlayTheRandomGame() {
        game.play();
        score = game.getScore();
    }

    @Then("the Random score should be greater than or equal to {long}")
    public void theRandomScoreShouldBeGreaterThanOrEqualTo(long arg0) {
        Assertions.assertTrue(score >= arg0);
    }

    @Then("there will be no Random scores")
    public void thereWillBeNoRandomScores() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            game.getScores();
        });
    }
}

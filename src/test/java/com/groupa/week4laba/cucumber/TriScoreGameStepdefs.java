package com.groupa.week4laba.cucumber;

import com.groupa.week4laba.game.Game;
import com.groupa.week4laba.game.TriScore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

public class TriScoreGameStepdefs {
    Game game;
    Long score;
    Long[] scores;

    @Given("I want to play TriScore")
    public void iWantToPlayTriScore() {
        game = new TriScore();
    }

    @When("^I play the TriScore game$")
    public void iPlayTheTriScoreGame() {
        game.play();
        score = game.getScore();
        scores = game.getScores();
    }

    @Then("the TriScore score should be greater than or equal to {long}")
    public void theTriScoreScoreShouldBeGreaterThanOrEqualTo(Long arg0) {
        Assertions.assertTrue(score >= arg0);
    }

    @And("less than {long}")
    public void lessThan(Long arg0) {
        Assertions.assertTrue(score < arg0);
    }

    @Then("the last TriScore scores is equal to score")
    public void theLastTriScoreScoresIsEqualToScore() {
        Assertions.assertEquals(score, scores[scores.length - 1]);
    }

    @Then("there are {int} TriScore scores returned")
    public void thereAreTriScoreScoresReturned(int arg0) {
        Assertions.assertEquals(arg0, scores.length);
    }
}

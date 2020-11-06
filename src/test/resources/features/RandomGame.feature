Feature: The Random game generates a score from 0 to Long.MAX_VALUE.

  Scenario: Play game
    Given I want to play Random
    When I play the Random game
    Then the Random score should be greater than or equal to 0

    Given I want to play Random
    When I play the Random game
    Then there will be no Random scores


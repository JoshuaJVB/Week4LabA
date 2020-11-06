Feature: The SnakeEyes game rolls 2 six-sided dice. For every game won, a
         certain amount of points are awarded and added to the score.

  Scenario: Play game
    Given I want to play SnakeEyes
    When I play the SnakeEyes game
    Then the SnakeEyes score should be greater than or equal to 0
    And less than or equal to 42000000

    Given I want to play SnakeEyes
    When I play the SnakeEyes game
    Then there will be no SnakeEyes scores


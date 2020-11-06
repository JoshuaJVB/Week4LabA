Feature: The TriScore game picks 3 random number and concatenates them into a final score.
  Scenario: Play game
    Given I want to play TriScore
    When I play the TriScore game
    Then the TriScore score should be greater than or equal to 0
    And less than 10000000000

    Given I want to play TriScore
    When I play the TriScore game
    Then the last TriScore scores is equal to score

    Given I want to play TriScore
    When I play the TriScore game
    Then there are 4 TriScore scores returned


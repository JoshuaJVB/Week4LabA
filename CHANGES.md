# Changes

## Sat, Oct 31, 2020 - andrew

### Week4LabAApplication.java

* Changed it to work with the changes, below.

### GameController

#### GET showLogin()

* Added / mapping

#### GET showResults()

* Added user attribute to model
* Changed hard-coded number 5 to the static, final value in the Game interface

#### POST pressedPlay()

* Added model object
* Updated user object with score of game played
* Added user, userScore, and leaderboard attributes to model

#### POST endGame()

* Added model object
* Added user attribute for model in OtherGame choice

### User model

* Made username to be unique column in H2 database
* Updated user's level on setScore method

### UserRepo

* Made findByUsername Optional instead of Iterable

### UserServiceImpl

* Changed isPresent() check to orElse(null)
* getUserByUsername now uses the repo's findByUsername method
* getUserByUsername creates a new user if the one being searched for does not exist

### Templates

* Added mock templates to show that some of it works

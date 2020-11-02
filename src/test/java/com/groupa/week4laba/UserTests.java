package com.groupa.week4laba;

import com.groupa.week4laba.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    User user1;
    User user2;

    @BeforeEach
    void setUp(){
        user1 = new User();
        user2 = new User("name");
    }

    @Test
    void setUserNameTest(){
        String expected = "NameGoesHere";
        user1.setUsername(expected);
        String actual = user1.getUsername();

        assertEquals(actual, expected);
    }

    @Test
    void setUserScoreTest(){
        Long expected = 100L;
        user1.setTotalScore(expected);
        Long actual = user1.getTotalScore();

        assertEquals(actual, expected);
    }

    @Test
    void setUserLevelTest(){
        Long expected = 1L;
        user1.setLevel(expected);
        Long actual = user1.getLevel();

        assertEquals(actual, expected);
    }

    @Test
    void confirmStartingValues(){
        assertAll(
                () -> assertEquals(1L, user2.getLevel()),
                () -> assertEquals(0L, user2.getTotalScore()),
                () -> assertEquals("name", user2.getUsername())
        );
    }

    @Test
    void incrementScoreTest(){
        user2.setScore(100L);
        user2.setScore(150L);
        Long expected = 250L;
        Long actual = user2.getTotalScore();

        assertEquals(expected, actual);
    }

    @Test
    void levelIncrementTest(){
        user2.addLevel();
        user2.addLevel();
        Long expected = 3L;
        Long actual = user2.getLevel();

        assertEquals(expected, actual);
    }
}

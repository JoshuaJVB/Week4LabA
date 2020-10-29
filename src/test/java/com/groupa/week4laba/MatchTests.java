package com.groupa.week4laba;

import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchTests {

    Match match;

    @BeforeEach
    void setUp(){
        match = new Match();
    }

    @Test
    void testSetScore(){
        match.setScore(100L);
        Long expected = 100L;
        Long actual = match.getScore();

        assertEquals(expected, actual);
    }

    @Test
    void testSetId(){
        match.setId(1L);
        Long actual = match.getId();

        assertEquals(1L, actual);
    }

    @Test
    void testSetUser() {
        User expected = new User("bill");
        match.setUser(expected);

        assertEquals(match.getUser(), expected);
    }
}

package com.groupa.week4laba.controller;

import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeaderboardTest {

    Leaderboard leaderboard;
    User user1;
    User user2;
    Match match1;
    Match match2;

    @BeforeEach
    void setUp(){
        leaderboard = new Leaderboard();
        user1 = new User("janine");
        user2 = new User("david");
        match1 = new Match(23L, user1, leaderboard);
        match2 = new Match(43L, user2, leaderboard);
    }

    @Test
    void testId(){
        Long expected = null;
        Long actual = leaderboard.getId();
        assertEquals(expected, actual);
    }

    @Test
    void testGetMatches(){
        List<Match> matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        leaderboard.setMatches(matches);
        assertEquals(matches, leaderboard.getMatches());
    }

    @Test
    void testGetClazz(){
        Leaderboard testLeaderboard = new Leaderboard("Random");
        assertEquals("Random",testLeaderboard.getClazz());
    }
}

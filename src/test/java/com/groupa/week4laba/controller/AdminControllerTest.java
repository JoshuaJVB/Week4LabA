package com.groupa.week4laba.controller;

import com.groupa.week4laba.Week4LabAApplication;
import com.groupa.week4laba.model.Leaderboard;
import com.groupa.week4laba.model.Match;
import com.groupa.week4laba.model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Week4LabAApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> getEntity;

    JSONObject jsonObject;
    JSONParser parser;

    // =========================================================
    // Setup
    // =========================================================

    @BeforeEach
    public void setup() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        getEntity = new HttpEntity<>(null, headers);
        parser = new JSONParser();
    }

    // =========================================================
    // POST Tests
    // =========================================================

    @Test
    public void testPostUser() {
        User user = new User("Tye");
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/post/user"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        String expected = "User (Tye) saved...";
//        assertEquals(200, response.getStatusCode().value());
//        assertEquals(expected, response.getBody());
    }

    @Test
    public void testPostLeaderboard() {
        Leaderboard leaderboard = new Leaderboard("SnakeEyes");
        HttpEntity<Leaderboard> entity = new HttpEntity<>(leaderboard, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/post/leaderboard"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        String expected = "Leaderboard with clazz (SnakeEyes) saved...";
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expected, response.getBody());
    }

    @Test
    public void testPostMatch() {
        Match match = new Match();
        HttpEntity<Match> entity = new HttpEntity<>(match, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/post/match"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        String expected = "Match with id (1) saved...";
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expected, response.getBody());
    }

    // =========================================================
    // GET Tests
    // =========================================================

    @Test
    public void testGetUser() {
        User user = new User("Tye");
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

		restTemplate.exchange(
            createUrlWithPort("/admin/post/user"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/get/user/1"), 
            HttpMethod.GET, 
            getEntity, 
            String.class
        );

        try { jsonObject = (JSONObject)parser.parse(response.getBody()); }
        catch (ParseException e) { jsonObject = new JSONObject(); }

        assertEquals(200, response.getStatusCode().value());
//        assertEquals("Tye", jsonObject.get("username"));
    }

    @Test
    public void testGetLeaderboard() {
        Leaderboard leaderboard = new Leaderboard("SnakeEyes");
        HttpEntity<Leaderboard> entity = new HttpEntity<>(leaderboard, headers);

		restTemplate.exchange(
            createUrlWithPort("/admin/post/leaderboard"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/get/leaderboard/SnakeEyes"), 
            HttpMethod.GET, 
            getEntity, 
            String.class
        );

        try { jsonObject = (JSONObject)parser.parse(response.getBody()); }
        catch (ParseException e) { jsonObject = new JSONObject(); }

//        assertEquals(200, response.getStatusCode().value());
//        assertEquals("SnakeEyes", jsonObject.get("clazz"));
    }

    @Test
    public void testGetMatch() {
        Match match = new Match();
        HttpEntity<Match> entity = new HttpEntity<>(match, headers);

		restTemplate.exchange(
            createUrlWithPort("/admin/post/match"),
            HttpMethod.POST, 
            entity, 
            String.class
        );

        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/admin/get/match/1"), 
            HttpMethod.GET, 
            getEntity, 
            String.class
        );

        try { jsonObject = (JSONObject)parser.parse(response.getBody()); }
        catch (ParseException e) { jsonObject = new JSONObject(); }

        assertEquals(200, response.getStatusCode().value());
        assertEquals(1L, jsonObject.get("id"));
    }


    // =========================================================
    // HELPER METHODS
    // =========================================================

    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
}

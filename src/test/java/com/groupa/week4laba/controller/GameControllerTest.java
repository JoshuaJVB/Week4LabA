package com.groupa.week4laba.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import com.groupa.week4laba.service.LeaderboardServiceImpl;
import com.groupa.week4laba.service.MatchServiceImpl;
import com.groupa.week4laba.service.UserServiceImpl;

/***********************************************************
 * @author  Tye Porter (github.com/tyeporter)
 * @version 0.1
 * @since   10-30-2020
 ***********************************************************/

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameControllerTest {

    private MockMvc mockMvc;
    private GameController controller;

    // =========================================================
    // Mock Beans
    // =========================================================

    @MockBean
    private MatchServiceImpl matchService;
    @MockBean
    private UserServiceImpl userService;
    @MockBean
    private LeaderboardServiceImpl leaderboardService;

    // =========================================================
    // Setup
    // =========================================================

    @BeforeEach
    public void setup() {
        this.controller = new GameController(matchService, userService, leaderboardService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // =========================================================
    // GET Tests
    // =========================================================

    @Test
    public void testShowLogin_ShouldReturnLoginView() throws Exception {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("login_page"));
    }

    @Test
    public void testShowGameChoices_ShouldReturnPickGameView() throws Exception {
        mockMvc.perform(get("/pickGame"))
            .andExpect(status().isOk())
            .andExpect(view().name("pick_game"));
    }

    @Test
    public void testShowGame_ShouldReturnPlayView() throws Exception {
        mockMvc.perform(get("/play"))
            .andExpect(status().isOk())
            .andExpect(view().name("play_game"));
    }

    @Test
    public void testShowResults_ShouldReturnResultsView() throws Exception {
        mockMvc.perform(get("/results"))
            .andExpect(status().isOk())
            .andExpect(view().name("results_page"));
    }

    // =========================================================
    // POST Tests
    // =========================================================

    // TODO: Figure out how to write tests for POST methods
    
}

package controller;

import com.bnisler.controller.LeagueController;
import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Ben on 2/4/2017.
 */
public class LeagueControllerTest {

    @InjectMocks
    private LeagueController leagueController;

//    @Autowired
//    private LeagueDao leagueDao;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(leagueController).build();
    }

//    @Test
//    public void test() throws Exception {
//        mockMvc.perform(get("/leagues")).andDo(print());
//    }

}

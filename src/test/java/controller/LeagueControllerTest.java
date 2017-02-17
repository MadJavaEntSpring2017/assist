package controller;

import com.bnisler.controller.LeagueController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class LeagueControllerTest {

    @InjectMocks
    private LeagueController leagueController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(leagueController).build();
    }

    @Test
    public void test() throws Exception {
//        mockMvc.perform(get("/leagues")).andDo(print());
    }

}

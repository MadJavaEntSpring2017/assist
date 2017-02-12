package persist;

import com.bnisler.entity.Division;
import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class LeagueDaoTest {

    private final Logger LOG = Logger.getLogger(LeagueDaoTest.class);
    private LeagueDao leagueDao;

    @Before
    public void setup() {
        leagueDao = new LeagueDao();
    }


//    @Test
//    public void testGetAllLeagues() {
//        List<League> leagues = leagueDao.getAllLeagues();
//        for (League league : leagues) { // TODO: LOG
//            System.out.println(league.toString());
//            for (Division division : league.getDivisions()) {
//                System.out.println(division.toString());
//            }
//        }
//        Assert.assertNotNull("DID NOT FIND ANY LEAGUES", leagues);
//        Assert.assertTrue("SIZE WASN'T > 0", leagues.size() > 0);
//    }
//
//    @Test
//    public void testGetLeagueById() {
//        int id = 1;
//        League league = leagueDao.getLeagueById(id);
//        System.out.println(league.toString()); // TODO: LOG
//        for (Division division : league.getDivisions()) {
//            System.out.println(division);
//        }
//
//        Assert.assertNotNull("SEARCH BY ID RETURNED NULL LEAGUE", league);
//        Assert.assertTrue("DID NOT FIND LEAGUE BY GIVEN ID", league.getId() == id);
//    }
//
//    @Test
//    public void testGetDivisions() {
//        int id = 1;
//        League league = leagueDao.getLeagueById(id);
//        for (Division division : league.getDivisions()) { // TODO: LOG
//            System.out.println(division.toString());
//        }
//
//        Assert.assertNotNull("SEARCH BY ID RETURNED NULL LEAGUE", league);
//        Assert.assertTrue("DID NOT FIND LEAGUE BY GIVEN ID", league.getId() == id);
//        Assert.assertNotNull("GET DIVISIONS FOR LEAGUE RETURNED NULL DIVISION", league.getDivisions());
//    }
}

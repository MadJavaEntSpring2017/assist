package persist;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
public class LeagueDaoTest {

    private final Logger LOG = Logger.getLogger(LeagueDaoTest.class);
    private LeagueDao leagueDao;

    @Before
    public void setup() {
        leagueDao = new LeagueDao();
    }

    @Test
    public void testGetAllLeagues() {
        List<League> leagues = leagueDao.getAllLeagues();
        for (League league : leagues) {
            System.out.println(league.toString());
        }
        Assert.assertNotNull("DID NOT FIND ANY LEAGUES", leagues);
        Assert.assertTrue("SIZE WASN'T > 0", leagues.size() > 0);
    }

    @Test
    public void testGetLeagueById() {
        int id = 1;
        League league = leagueDao.getLeagueById(id);
        System.out.println(league.toString());

        Assert.assertNotNull("SEARCH BY ID RETURNED NULL LEAGUE", league);
        Assert.assertTrue("DID NOT FIND LEAGUE BY GIVEN ID", league.getId() == id);
    }
}

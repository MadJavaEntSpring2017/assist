package dao;

import com.bnisler.entity.League;
import com.bnisler.dao.LeagueDao;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class LeagueDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(LeagueDaoTest.class);

    @Autowired
    private LeagueDao leagueDao;

    @Test
    public void testGetAllLeagues() {
        List<League> leagues = null;
        leagues = leagueDao.getAllLeagues();

        LOG.info(leagues);
        Assert.assertNotNull("Didn't pull back leagues", leagues);
        Assert.assertTrue("Couldn't find any leagues", leagues.size() > 0);
    }

    @Test
    public void testGetLeagueById() {
        int id = 1;
        League league = null;
        league = leagueDao.getLeagueById(id);

        LOG.info(league);
        Assert.assertNotNull("Didn't pull back a league", league);
        Assert.assertTrue("Wrong league", league.getId() == 1);
    }
}

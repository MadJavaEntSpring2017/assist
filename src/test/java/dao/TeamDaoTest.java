package dao;

import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Team;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(TeamDaoTest.class);

    @Autowired
    private TeamDao teamDao;

    @Test
    public void testGetAllTeams() {
        List<Team> teams = null;
        teams = teamDao.getAllTeams();

        LOG.info(teams);
        Assert.assertNotNull("Didn't pull back teams", teams);
        Assert.assertTrue("Couldn't find any teams", teams.size() > 0);
    }

    @Test
    public void testGetTeamById() {
        int id = 1;
        Team team = null;
        team = teamDao.getTeamById(id);

        LOG.info(team);
        Assert.assertNotNull("Didn't pull back a team", team);
        Assert.assertTrue("Wrong team", team.getId() == 1);
    }
}

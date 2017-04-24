package dao;

import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Team;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeamDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(TeamDaoTest.class);

    @Autowired
    private TeamDao teamDao;
    private Team team;

    @Before
    public void setup() {
        Team team = new Team();
        team.setName("FC Bucky");
        team.setActive(true);
        this.team = team;
    }

    @Test
    public void testGetAllTeams() {
        List<Team> teams = null;
        teams = teamDao.findAllTeams();

        LOG.info(teams);
        Assert.assertNotNull("Didn't pull back teams", teams);
        Assert.assertTrue("Couldn't find any teams", teams.size() > 0);
    }

    @Test
    public void testGetTeamById() {
        Long id = 1L;
        Team team = null;
        team = teamDao.findTeamById(id);

        LOG.info(team);
        Assert.assertNotNull("Didn't pull back a team", team);
        Assert.assertTrue("Wrong team", team.getId().equals(id));
    }

    @Test
    public void testCreateTeam() {
        Long id = teamDao.saveTeam(team);
        Team savedTeam = teamDao.findTeamById(id);

        LOG.info(savedTeam + " in testCreateTeam()");
        Assert.assertNotNull("Couldn't save team", savedTeam);
        Assert.assertTrue("Wrong team id", id.equals(savedTeam.getId()));
        Assert.assertTrue("Wrong team name", team.getName().equals(savedTeam.getName()));
    }

    @Test
    public void testUpdateTeam() {
        Long id = teamDao.saveTeam(team);
        Team savedTeam = teamDao.findTeamById(id);

        LOG.info(savedTeam + " in testUpdateTeam()");
        Assert.assertNotNull("Couldn't save team", savedTeam);
        Assert.assertTrue("Wrong team id", id.equals(savedTeam.getId()));
        Assert.assertTrue("Wrong team name", team.getName().equals(savedTeam.getName()));

        String expectedName = "Updated";
        savedTeam.setName(expectedName);
        teamDao.updateTeam(savedTeam);

        Team updatedTeam = teamDao.findTeamById(savedTeam.getId());
        String actualName = updatedTeam.getName();

        LOG.info(updatedTeam);
        Assert.assertTrue("Couldn't update team", expectedName.equals(actualName));
    }
}

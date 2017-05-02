package dao;

import com.bnisler.dao.RosterDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Roster;
import com.bnisler.entity.Session;
import com.bnisler.entity.Team;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RosterDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(RosterDaoTest.class);

    @Autowired
    private RosterDao rosterDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private SessionDao sessionDao;

    private Roster constraintRoster;
    private Roster saveRoster;

    @Before
    public void setup() {
        Roster roster1 = new Roster();
        Team team1 = teamDao.findTeamById(1L);
        Session session1 = sessionDao.findSessionById(1L);
        roster1.setTeam(team1);
        roster1.setSession(session1);
        this.constraintRoster = roster1;

        Team team2 = new Team();
        team2.setActive(true);
        team2.setName("Fake");
        Long team2Id = teamDao.saveTeam(team2);

        Roster roster2 = new Roster();
        team2 = teamDao.findTeamById(team2Id);
        Session session2 = sessionDao.findSessionById(1L);
        roster2.setTeam(team2);
        roster2.setSession(session2);
        this.saveRoster = roster2;
    }

    @Test
    public void testFindAllRosters() {
        List<Roster> rosters = null;
        rosters = rosterDao.findAllRosters();

        LOG.info(rosters);
        Assert.assertNotNull("Couldn't pull back rosters", rosters);
        Assert.assertTrue("Couldn't find any rosters", rosters.size() > 0);
    }

    @Test
    public void testFindRosterById() {
        Long rosterId = 1L;
        Roster roster = null;
        roster = rosterDao.findRosterById(rosterId);

        LOG.info(roster);
        Assert.assertNotNull("Couldn't pull back the constraintRoster", roster);
        Assert.assertTrue("Couldn't find the constraintRoster", roster.getId().equals(rosterId));
        Assert.assertNotNull("Couldn't pull back constraintRoster's team", roster.getTeam());
        Assert.assertNotNull("Couldn't pull back constraintRoster's session", roster.getSession());
    }

    @Test
    public void testTeamSessionConstraint() {
        Long rosterId = null;

        try {
            rosterId = rosterDao.saveRoster(constraintRoster);
        } catch (ConstraintViolationException cve) {
            LOG.info("Caught constraint, appropriately did not save constraintRoster");
            Assert.assertNotNull("Couldn't catch exception", cve);
        }

        Assert.assertNull("Roster saved when shouldn't have been", rosterId);
    }

    @Test
    public void testSaveRoster() {
        Long rosterId = rosterDao.saveRoster(saveRoster);
        Roster savedRoster = rosterDao.findRosterById(rosterId);

        LOG.info(savedRoster + " in testSaveRoster()");
        Assert.assertNotNull("Couldn't save saveRoster", savedRoster);
        Assert.assertTrue("Wrong saveRoster id", savedRoster.getId().equals(rosterId));
        Assert.assertTrue("Wrong team", savedRoster.getTeam().equals(saveRoster.getTeam()));
        Assert.assertTrue("Wrong session", savedRoster.getSession().equals(saveRoster.getSession()));
    }
}

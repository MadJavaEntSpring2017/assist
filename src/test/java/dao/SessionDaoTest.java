package dao;

import com.bnisler.dao.SeasonDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.dao.SplitDao;
import com.bnisler.entity.Season;
import com.bnisler.entity.Session;
import com.bnisler.entity.Split;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SessionDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(SeasonDaoTest.class);

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private SplitDao splitDao;

    private Session session;

    @Before
    public void setup() {
        Session session = new Session();
        Season season = seasonDao.findSeasonById(1L);
        session.setSeason(season);
        Split split = splitDao.findSplitById(1L);
        session.setSplit(split);
        this.session = session;
    }

    @Test
    public void testFindAllSessions() {
        List<Session> sessions = null;
        sessions = sessionDao.findAllSessions();

        LOG.info(sessions);
        Assert.assertNotNull("Couldn't pull back sessions", sessions);
        Assert.assertTrue("Couldn't find any sessions", sessions.size() > 0);
    }

    @Test
    public void testFindSessionById() {
        Long sessionId = 1L;
        Session session = null;
        session = sessionDao.findSessionById(sessionId);

        LOG.info(session);
        Assert.assertNotNull("Couldn't pull back the session", session);
        Assert.assertTrue("Couldn't find the session", session.getId().equals(sessionId));
    }

    @Test
    public void testSaveSession() {
        Long sessionId = sessionDao.saveSession(session);
        Session savedSession = sessionDao.findSessionById(sessionId);

        LOG.info(savedSession + " in testSaveSession()");
        Assert.assertNotNull("Couldn't save session", savedSession);
        Assert.assertTrue("Wrong session id", savedSession.getId().equals(sessionId));
        Assert.assertTrue("Wrong season", savedSession.getSeason().equals(session.getSeason()));
        Assert.assertTrue("Wrong split", savedSession.getSplit().equals(session.getSplit()));
    }

    @Test
    public void testUpdateSession() {
        Long sessionId = sessionDao.saveSession(session);
        Session savedSession = sessionDao.findSessionById(sessionId);

        LOG.info(savedSession + " in testUpdateSession()");
        Assert.assertNotNull("Couldn't save session", savedSession);
        Assert.assertTrue("Wrong session id", savedSession.getId().equals(sessionId));
        Assert.assertTrue("Wrong season", savedSession.getSeason().equals(session.getSeason()));
        Assert.assertTrue("Wrong split", savedSession.getSplit().equals(session.getSplit()));

        Long expectedSplitId = 2L;
        Split expectedSplit = splitDao.findSplitById(expectedSplitId);
        savedSession.setSplit(expectedSplit);
        sessionDao.updateSession(savedSession);

        Session updatedSession = sessionDao.findSessionById(savedSession.getId());
        Long actualSplitId = updatedSession.getSplit().getId();

        LOG.info(updatedSession);
        Assert.assertTrue("Couldn't update session", expectedSplitId.equals(actualSplitId));
    }
}

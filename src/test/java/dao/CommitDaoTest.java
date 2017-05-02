package dao;

import com.bnisler.dao.CommitDao;
import com.bnisler.dao.PlayerDao;
import com.bnisler.dao.RosterDao;
import com.bnisler.entity.Commit;
import com.bnisler.entity.Player;
import com.bnisler.entity.Roster;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommitDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(CommitDaoTest.class);

    @Autowired
    private CommitDao commitDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private RosterDao rosterDao;

    private Commit commit;

    @Before
    public void setup() {
        Commit commit = new Commit();
        Long playerId = 4L;
        Player player = playerDao.findById(playerId);
        Long rosterId = 1L;
        Roster roster = rosterDao.findRosterById(rosterId);
        commit.setPlayer(player);
        commit.setRoster(roster);
        this.commit = commit;
    }

    @Test
    public void testFindAllCommits() {
        List<Commit> commits = null;
        commits = commitDao.findAllCommits();

        LOG.info(commits);
        Assert.assertNotNull("Couldn't pull back commits", commits);
        Assert.assertTrue("Couldn't find any commits", commits.size() > 0);
    }

    @Test
    public void testFindCommitById() {
        Long commitId = 1L;
        Commit commit = null;
        commit = commitDao.findCommitById(commitId);

        LOG.info(commit);
        Assert.assertNotNull("Couldn't pull back the commit", commit);
        Assert.assertTrue("Couldn't find the commit", commit.getId().equals(commitId));
        Assert.assertNotNull("Couldn't pull back player", commit.getPlayer());
        Assert.assertNotNull("Couldn't pull back roster", commit.getRoster());
    }

    @Test
    public void testSaveCommit(){
        Long commitId = commitDao.saveCommit(commit);
        Commit savedCommit = commitDao.findCommitById(commitId);

        LOG.info(savedCommit + " in testSaveCommit()");
        Assert.assertNotNull("Couldn't save commit", savedCommit);
        Assert.assertTrue("Wrong commit id", savedCommit.getId().equals(commitId));
        Assert.assertTrue("Wrong player", savedCommit.getPlayer().equals(commit.getPlayer()));
        Assert.assertTrue("Wrong roster", savedCommit.getRoster().equals(commit.getRoster()));
    }
}

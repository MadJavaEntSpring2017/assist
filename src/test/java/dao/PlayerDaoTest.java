package dao;

import com.bnisler.dao.PlayerDao;
import com.bnisler.entity.Player;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(PlayerDaoTest.class);

    @Autowired
    private PlayerDao playerDao;

    @Test
    public void testGetAllPlayers() {
        List<Player> players = null;
        players = playerDao.findAllPlayers();

        LOG.info(players);
        Assert.assertNotNull("Didn't pull back players", players);
        Assert.assertTrue("Couldn't find any players", players.size() > 0);
    }
}

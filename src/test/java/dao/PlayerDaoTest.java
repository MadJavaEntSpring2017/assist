package dao;

import com.bnisler.dao.PlayerDao;
import com.bnisler.entity.Player;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PlayerDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(PlayerDaoTest.class);

    @Autowired
    private PlayerDao playerDao;
    private Player player;

    @Before
    public void setup() {
        Player player = new Player();
        player.setFirstname("New");
        player.setLastname("Player");
        player.setBirthday(new Date());
        player.setActive(true);
        player.setEmail("np@gmail.com");
        this.player = player;
    }

    @Test
    public void testGetAllPlayers() {
        List<Player> players = null;
        players = playerDao.findAllPlayers();

        LOG.info(players);
        Assert.assertNotNull("Didn't pull back players", players);
        Assert.assertTrue("Couldn't find any players", players.size() > 0);
    }

    @Test
    public void testGetPlayerById() {
        Long id = 1L;
        Player player = null;
        player = playerDao.findById(id);

        LOG.info(player);
        Assert.assertNotNull("Didn't pull back a player", player);
        Assert.assertTrue("Wrong player", player.getId().equals(id));
    }

    @Test
    public void testSavePlayer() {
        Long id = playerDao.savePlayer(player);
        Player savedPlayer = playerDao.findById(id);

        LOG.info(savedPlayer + " in testSavePlayer()");
        Assert.assertNotNull("Couldn't save player", savedPlayer);
        Assert.assertTrue("Wrong player id", id.equals(savedPlayer.getId()));
        Assert.assertTrue("Wrong player firstname", player.getFirstname().equals(savedPlayer.getFirstname()));
        Assert.assertTrue("Wrong player lastname", player.getLastname().equals(savedPlayer.getLastname()));
        Assert.assertTrue("Wrong player email", player.getEmail().equals(savedPlayer.getEmail()));
    }

    @Test
    public void testDeletePlayer() {
        Long id = playerDao.save(player);
        Player savedPlayer = playerDao.findById(id);

        LOG.info(savedPlayer + " in testDeletePlayer()");
        Assert.assertNotNull("Couldn't save player", savedPlayer);
        Assert.assertTrue("Wrong player id", id.equals(savedPlayer.getId()));
        Assert.assertTrue("Wrong player firstname", player.getFirstname().equals(savedPlayer.getFirstname()));
        Assert.assertTrue("Wrong player lastname", player.getLastname().equals(savedPlayer.getLastname()));
        Assert.assertTrue("Wrong player email", player.getEmail().equals(savedPlayer.getEmail()));

        playerDao.deletePlayer(savedPlayer);
        Player deletedPlayer = playerDao.findById(savedPlayer.getId());
        Assert.assertNull("Unable to delete player", deletedPlayer);
    }

    @Test
    public void testUpdatePlayer() {
        Long id = playerDao.savePlayer(player);
        Player savedPlayer = playerDao.findById(id);

        LOG.info(savedPlayer + " in testUpdatePlayer()");
        Assert.assertNotNull("Couldn't save player", savedPlayer);
        Assert.assertTrue("Wrong player id", id.equals(savedPlayer.getId()));
        Assert.assertTrue("Wrong player firstname", player.getFirstname().equals(savedPlayer.getFirstname()));
        Assert.assertTrue("Wrong player lastname", player.getLastname().equals(savedPlayer.getLastname()));
        Assert.assertTrue("Wrong player email", player.getEmail().equals(savedPlayer.getEmail()));

        String expectedFirstname = "Updated";
        savedPlayer.setFirstname(expectedFirstname);
        playerDao.updatePlayer(savedPlayer);

        Player updatedPlayer = playerDao.findById(savedPlayer.getId());
        String actualFirstname = updatedPlayer.getFirstname();

        LOG.info(updatedPlayer);
        Assert.assertTrue("Couldn't update player", expectedFirstname.equals(actualFirstname));
    }
}

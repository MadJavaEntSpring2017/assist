package mapper;

import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Player;
import com.bnisler.entity.Team;
import com.bnisler.service.player.PlayerDetail;
import com.bnisler.service.player.PlayerMapper;
import com.bnisler.service.player.PlayerWriteRequest;
import dao.BaseDaoTest;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class PlayerMapperTest extends BaseDaoTest {

    private Logger LOG = Logger.getLogger(PlayerMapperTest.class);

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TeamDao teamDao;

    private PlayerWriteRequest writeRequest;

    @Before
    public void setup() {
        PlayerWriteRequest writeRequest = new PlayerWriteRequest();
        writeRequest.setFirstname("Firstname");
        writeRequest.setLastname("Lastname");
        writeRequest.setBirthday(new Date());
        writeRequest.setActive(true);
        writeRequest.setEmail("fl@me.com");
        this.writeRequest = writeRequest;
    }

    @Test
    public void testMapToEntity() {
        Player player = new Player();
        playerMapper.mapToEntity(writeRequest, player);

        LOG.info(player);
        Assert.assertNotNull("Couldn't instantiate player", player);
        Assert.assertNull("New player so id should be null", player.getId());
        Assert.assertTrue("Couldn't copy firstname", player.getFirstname().equals(writeRequest.getFirstname()));
        Assert.assertTrue("Couldn't copy lastname", player.getLastname().equals(writeRequest.getLastname()));
        Assert.assertTrue("Couldn't copy email", player.getEmail().equals(writeRequest.getEmail()));
    }

    @Test
    public void testMapEntityToDetail() {
        Long teamId = 1L;
        Team team = teamDao.findTeamById(teamId);

        Player player = new Player();
        playerMapper.mapToEntity(writeRequest, player);

        LOG.info(player);
        Assert.assertNotNull("Couldn't instantiate player", player);
        Assert.assertNull("New player so id should be null", player.getId());
        Assert.assertTrue("Couldn't copy firstname", player.getFirstname().equals(writeRequest.getFirstname()));
        Assert.assertTrue("Couldn't copy lastname", player.getLastname().equals(writeRequest.getLastname()));
        Assert.assertTrue("Couldn't copy email", player.getEmail().equals(writeRequest.getEmail()));

        player.setTeam(team);

        PlayerDetail playerDetail = new PlayerDetail();
        playerMapper.mapEntityToDetail(player, playerDetail);

        LOG.info(playerDetail);
        Assert.assertNotNull("Couldn't instantiate player detail", playerDetail);
        Assert.assertNotNull("Couldn't bring back player's team", playerDetail.getTeam());
        Assert.assertTrue("Couldn't copy firstname", playerDetail.getFirstname().equals(writeRequest.getFirstname()));
        Assert.assertTrue("Couldn't copy lastname", playerDetail.getLastname().equals(writeRequest.getLastname()));
        Assert.assertTrue("Couldn't copy email", playerDetail.getEmail().equals(writeRequest.getEmail()));
        Assert.assertTrue("Couldn't copy team name", playerDetail.getTeam().getName().equals(team.getName()));
        Assert.assertTrue("Couldn't copy team id", playerDetail.getTeam().getId().equals(team.getId()));
    }
}

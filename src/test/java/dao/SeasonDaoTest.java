package dao;

import com.bnisler.dao.SeasonDao;
import com.bnisler.entity.Season;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeasonDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(SeasonDaoTest.class);

    @Autowired
    private SeasonDao seasonDao;
    private Season season;

    @Before
    public void setup() {
        Season season = new Season();
        season.setName("Fall2014/Spring2015");
        season.setActive(true);
        this.season = season;
    }

    @Test
    public void testGetAllSeasons() {
        List<Season> seasons = null;
        seasons = seasonDao.findAllSeasons();

        LOG.info(seasons);
        Assert.assertNotNull("Didn't pull back any seasons", seasons);
        Assert.assertTrue("Couldn't find any seasons", seasons.size() > 0);
    }

    @Test
    public void testGetSeasonById() {
        Long seasonId = 1L;
        Season searchedSeason = null;
        searchedSeason = seasonDao.findSeasonById(seasonId);

        LOG.info(searchedSeason);
        Assert.assertNotNull("Didn't pull back a season", searchedSeason);
        Assert.assertTrue("Couldn't find the season", seasonId.equals(searchedSeason.getId()));
    }

    @Test
    public void testSaveSeason(){
        Long seasonId = seasonDao.saveSeason(season);
        Season savedSeason = seasonDao.findSeasonById(seasonId);

        LOG.info(savedSeason + "in testSaveSeason()");
        Assert.assertNotNull("Couldn't save season", savedSeason);
        Assert.assertTrue("Wrong season id", seasonId.equals(savedSeason.getId()));
        Assert.assertTrue("Wrong active boolean", savedSeason.isActive() == season.isActive());
        Assert.assertTrue("Wrong season name", season.getName().equals(savedSeason.getName()));
    }

    @Test
    public void testUpdateSeason() {
        Long seasonId = seasonDao.saveSeason(season);
        Season savedSeason = seasonDao.findSeasonById(seasonId);

        LOG.info(savedSeason + "in testUpdateSeason()");
        Assert.assertNotNull("Couldn't save season", savedSeason);
        Assert.assertTrue("Wrong season id", seasonId.equals(savedSeason.getId()));
        Assert.assertTrue("Wrong active boolean", savedSeason.isActive() == season.isActive());
        Assert.assertTrue("Wrong season name", season.getName().equals(savedSeason.getName()));

        String expectedName = "Updated";
        savedSeason.setName(expectedName);
        seasonDao.updateSeason(savedSeason);

        Season updatedSeason = seasonDao.findSeasonById(savedSeason.getId());
        String actualName = updatedSeason.getName();

        LOG.info(updatedSeason);
        Assert.assertTrue("Couldn't update season", expectedName.equals(actualName));
    }
}

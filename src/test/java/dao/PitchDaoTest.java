package dao;

import com.bnisler.dao.PitchDao;
import com.bnisler.entity.Pitch;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PitchDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private PitchDao pitchDao;

    @Test
    public void testGetAllPitches() {
        List<Pitch> pitches = null;
        pitches = pitchDao.getAllPitches();

        LOG.info(pitches);
        Assert.assertNotNull("Didn't pull back pitches", pitches);
        Assert.assertTrue("Couldn't find any pitches", pitches.size() > 0);
    }
}

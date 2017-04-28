package dao;

import com.bnisler.dao.SplitDao;
import com.bnisler.entity.Split;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SplitDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(SplitDaoTest.class);

    @Autowired
    private SplitDao splitDao;
    private Split split;

    @Before
    public void setup() {
        Split split = new Split();
        split.setName("Winter");
        this.split = split;
    }

    @Test
    public void testFindAllSplits() {
        List<Split> splits = null;
        splits = splitDao.findAllSplits();

        LOG.info(splits);
        Assert.assertNotNull("Didn't pull back any splits", splits);
        Assert.assertTrue("Couldn't find any splits", splits.size() > 0);
    }

    @Test
    public void testFindSplitById() {
        Long splitId = 1L;
        Split searchedSplit = null;
        searchedSplit = splitDao.findSplitById(splitId);

        LOG.info(searchedSplit);
        Assert.assertNotNull("Didn't pull back a split", searchedSplit);
        Assert.assertTrue("Couldn't find the split", searchedSplit.getId().equals(splitId));
    }

    @Test
    public void testSaveSplit() {
        Long splitId = splitDao.saveSplit(split);
        Split savedSplit = splitDao.findSplitById(splitId);

        LOG.info(savedSplit + " in testSaveSplit()");
        Assert.assertNotNull("Couldn't save split", savedSplit);
        Assert.assertTrue("Wrong split id", splitId.equals(savedSplit.getId()));
        Assert.assertTrue("Wrong split name", split.getName().equals(savedSplit.getName()));
    }

    @Test
    public void testUpdateSplit() {
        Long splitId = splitDao.saveSplit(split);
        Split savedSplit = splitDao.findSplitById(splitId);

        LOG.info(savedSplit + " in testUpdateSplit()");
        Assert.assertNotNull("Couldn't save split", savedSplit);
        Assert.assertTrue("Wrong split id", splitId.equals(savedSplit.getId()));
        Assert.assertTrue("Wrong split name", split.getName().equals(savedSplit.getName()));

        String expectedName = "Updated";
        savedSplit.setName(expectedName);
        splitDao.updateSplit(savedSplit);

        Split updatedSplit = splitDao.findSplitById(savedSplit.getId());
        String actualName = updatedSplit.getName();

        LOG.info(updatedSplit);
        Assert.assertTrue("Couldn't update split", expectedName.equals(actualName));
    }
}

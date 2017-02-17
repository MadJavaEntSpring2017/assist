package dao;

import com.bnisler.dao.ManagerDao;
import com.bnisler.entity.Manager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManagerDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(ManagerDaoTest.class);

    @Autowired
    private ManagerDao managerDao;

    @Test
    public void testGetAllManagers() {
        List<Manager> managers = null;
        managers = managerDao.getAllManagers();

        LOG.info(managers);
        Assert.assertNotNull("Couldn't pull back any managers", managers);
        Assert.assertTrue("No managers", managers.size() > 0);
    }

    @Test
    public void testGetManagerById() {
        int id = 1;
        Manager manager = null;
        manager = managerDao.getManagerById(id);

        LOG.info(manager);
        Assert.assertNotNull("Couldn't pull back manager", manager);
        Assert.assertTrue("Wrong manager", manager.getId() == id);
    }
}

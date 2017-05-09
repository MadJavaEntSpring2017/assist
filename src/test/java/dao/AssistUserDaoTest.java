package dao;

import com.bnisler.dao.AssistUserDao;
import com.bnisler.entity.AssistUser;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AssistUserDaoTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(AssistUserDaoTest.class);

    @Autowired
    private AssistUserDao assistUserDao;

    @Test
    public void testFindByUsername() {
        String username = "bnisler";
        AssistUser user = null;
        user = assistUserDao.findByUsername(username);
        LOG.info(user);

        Assert.assertNotNull("Couldn't bring back user", user);
        Assert.assertTrue("Wrong username", user.getUsername().equals(username));
    }
}

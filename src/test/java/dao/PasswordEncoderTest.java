package dao;

import com.bnisler.dao.AssistUserDao;
import com.bnisler.entity.AssistUser;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest extends BaseDaoTest {

    private final Logger LOG = Logger.getLogger(PasswordEncoderTest.class);

    @Test
    public void testBCryptHash() {
        String password = "password";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);
        LOG.info(hashedPassword);

        Assert.assertTrue("Password mismatch", encoder.matches(password, hashedPassword));
    }

    @Test
    public void testMD5Hash() {
        String password = "password";
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String hashedPassword = encoder.encodePassword(password, null);
        LOG.info(hashedPassword);

        Assert.assertTrue("Password mismatch", hashedPassword.matches(encoder.encodePassword(password, null)));
    }
}

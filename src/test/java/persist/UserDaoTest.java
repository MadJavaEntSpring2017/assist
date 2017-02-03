package persist;

import com.bnisler.entity.User;
import com.bnisler.persist.UserDao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ben on 2/2/2017.
 */
public class UserDaoTest {

    private Logger log = Logger.getLogger(UserDaoTest.class);

    UserDao dao;

    @Before
    public void setup() {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        int id = 1;
        User user = dao.getUser(id);
        assertNotNull("user is NULL", user);
    }

    @Test
    public void addUser() throws Exception {
        int id = 0;
        String firstName = "Benjamin";
        String lastName = "Nisler";
        LocalDate dateOfBirth = LocalDate.of(1986, 4, 23);

        int newUserId = dao.addUser(new User(id, firstName, lastName, dateOfBirth));
        assertNotNull("couldn't find newly made user", dao.getUser(newUserId));
        assertTrue("incorrect last name", dao.getUser(newUserId).getLastName().equals(lastName));
    }

    @Test
    public void deleteUser() throws Exception {
        int id = 0;
        String firstName = "Benjamin";
        String lastName = "Nisler";
        LocalDate dateOfBirth = LocalDate.of(1986, 4, 23);

        int newUserId = dao.addUser(new User(id, firstName, lastName, dateOfBirth));
        assertNotNull("couldn't find newly made user", dao.getUser(newUserId));
        assertTrue("incorrect last name", dao.getUser(newUserId).getLastName().equals(lastName));

        dao.deleteUser(newUserId);
        assertNull("user should not be here", dao.getUser(newUserId));
    }

    @Test
    public void updateUser() throws Exception {
        int id = 1;
        String newLastName = "UpdatedLastName";

        User user = dao.getUser(id);
        user.setLastName(newLastName);
        dao.updateUser(user);

        assertFalse("couldn't update user", !dao.getUser(id).getLastName().equals(newLastName));
    }

}

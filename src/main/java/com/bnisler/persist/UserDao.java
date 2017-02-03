package com.bnisler.persist;

import com.bnisler.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Ben on 2/2/2017.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return session.createCriteria(User.class).list();
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (User) session.get(User.class, id);
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(user);
        transaction.commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getUser(id));
        transaction.commit();
    }

    /**
     * Update the user
     * @param user
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }




}

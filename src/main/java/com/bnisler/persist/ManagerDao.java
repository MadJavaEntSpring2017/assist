package com.bnisler.persist;

import com.bnisler.entity.Manager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ben on 2/12/2017.
 */
@Repository
public class ManagerDao {

    private final Logger LOG = Logger.getLogger(ManagerDao.class);

    @Autowired
    private SessionFactory sessionFactory;

    public List<Manager> getAllManagers() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Manager.class).list();
    }
}

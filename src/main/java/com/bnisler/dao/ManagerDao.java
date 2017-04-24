package com.bnisler.dao;

import com.bnisler.entity.Manager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Manager> getAllManagers() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Manager.class).list();
    }

    public Manager getManagerById(Long id) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        return (Manager) session.get(Manager.class, id);
    }
}

package com.bnisler.dao;

import com.bnisler.entity.AssistUser;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class AssistUserDao extends AbstractDao<Long, AssistUser> {

    @Autowired
    private SessionFactory sessionFactory;

    public AssistUser findByUsername(String username) throws UsernameNotFoundException {
        Session session;
        try {
            session = getSession();
        } catch (HibernateException he) {
            session = sessionFactory.openSession();
        }

        Query query = session.createQuery("FROM AssistUser u WHERE u.username = :username");
        query.setParameter("username", username);
        AssistUser user = (AssistUser) query.uniqueResult();
        if (user == null) {
            throw new UsernameNotFoundException("User with username '" + username + "' not found.");
        }
        return user;
    }
}

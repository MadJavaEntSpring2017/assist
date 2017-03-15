package com.bnisler.dao;

import com.bnisler.entity.Pitch;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PitchDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Pitch> getAllPitches() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pitch.class).list();
    }
}

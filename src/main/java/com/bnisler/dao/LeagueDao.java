package com.bnisler.dao;

import com.bnisler.entity.Division;
import com.bnisler.entity.League;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LeagueDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets all leagues and their divisions.
     *
     * @return the all leagues
     */
    public List<League> getAllLeagues() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        List<League> leagues = session.createCriteria(League.class).list();
        for (League league : leagues) {
            for (Division division : league.getDivisions()) {
                division.getName();
            }
        }

        return leagues;
    }

    /**
     * Gets league by id and its divisions.
     *
     * @param id the id
     * @return the league by id
     */
    public League getLeagueById(Long id) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        League league = (League) session.get(League.class, id);
        for (Division division : league.getDivisions()) {
            division.getName();
        }

        return league;
    }
}

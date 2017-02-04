package com.bnisler.persist;

import com.bnisler.entity.League;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
public class LeagueDao {

    private final Logger LOG = Logger.getLogger(LeagueDao.class);

    /**
     * Gets all leagues.
     *
     * @return the all leagues
     */
    public List<League> getAllLeagues() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return session.createCriteria(League.class).list();
    }

    /**
     * Gets league by id.
     *
     * @param id the id
     * @return the league by id
     */
    public League getLeagueById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        return (League) session.get(League.class, id);
    }
}

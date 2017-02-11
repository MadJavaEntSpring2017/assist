package com.bnisler.persist;

import com.bnisler.entity.Division;
import com.bnisler.entity.League;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.util.List;

public class LeagueDao {

    private final Logger LOG = Logger.getLogger(LeagueDao.class);

    /**
     * Gets all leagues.
     *
     * @return the all leagues
     */
    public List<League> getAllLeagues() throws HibernateException {
            Session session = SessionFactoryProvider.getSessionFactory().openSession();
            List<League> leagues = session.createCriteria(League.class).list();
            for (League league : leagues) {
                for (Division division : league.getDivisions()) {
                    division.getName();
                }
            }

            return leagues;
    }

    /**
     * Gets league by id.
     *
     * @param id the id
     * @return the league by id
     */
    public League getLeagueById(int id) throws HibernateException {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        League league = (League) session.get(League.class, id);
        for (Division division : league.getDivisions()) {
            division.getName();
        }

        return league;
    }
}

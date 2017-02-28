package com.bnisler.dao;

import com.bnisler.entity.Team;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Team dao.
 */
@Repository
public class TeamDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets all teams.
     *
     * @return the all teams
     * @throws HibernateException the hibernate exception
     */
    public List<Team> getAllTeams() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        List<Team> teams = session.createCriteria(Team.class).list();
        for (Team team : teams) {
            team.getDivision().getName();
//            team.getManager().getFirstname(); // TODO: uncomment when security implemented
        }

        return teams;
    }

    /**
     * Gets team by id.
     *
     * @param id the id
     * @return the team by id
     * @throws HibernateException the hibernate exception
     */
    public Team getTeamById(int id) throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        Team team = (Team) session.get(Team.class, id);
        team.getDivision().getName();
        return team;
    }
}

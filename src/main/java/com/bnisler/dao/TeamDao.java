package com.bnisler.dao;

import com.bnisler.entity.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Team dao.
 */
@Repository("teamDao")
public class TeamDao extends AbstractDao<Integer, Team> {

    @SuppressWarnings("unchecked")
    public List<Team> getAllTeams() {
        Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
    }

    public Team getTeamById(int id) {
        return getByKey(id);
    }
}

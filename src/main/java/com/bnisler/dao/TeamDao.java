package com.bnisler.dao;

import com.bnisler.entity.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teamDao")
public class TeamDao extends AbstractDao<Integer, Team> {

    @SuppressWarnings("unchecked")
    public List<Team> findAllTeams() {
        Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
    }

    public Team findTeamById(int id) {
        return getByKey(id);
    }

    public int saveTeam(Team team) {
        return save(team);
    }

    public void updateTeam(Team team) {
        update(team);
    }
}

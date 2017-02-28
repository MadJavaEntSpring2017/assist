package com.bnisler.service;

import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    public List<Team> findAllTeams() { return teamDao.getAllTeams(); }

    public Team findTeamById(int id) { return teamDao.getTeamById(id); }
}

package com.bnisler.service.team;

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

    @Autowired
    private TeamMapper teamMapper;

    public List<Team> findAllTeams() { return teamDao.findAllTeams(); }

    public Team findTeamById(Long id) { return teamDao.findTeamById(id); }

    @Transactional
    public Long createTeam(TeamWriteRequest writeRequest) {
        Team team = new Team();
        teamMapper.mapToEntity(writeRequest, team);
        return teamDao.saveTeam(team);
    }

    @Transactional
    public void updateTeam(Long teamId, TeamWriteRequest writeRequest) {
        Team team = teamDao.findTeamById(teamId);
        teamMapper.mapToEntity(writeRequest, team);
        teamDao.updateTeam(team);
    }
}

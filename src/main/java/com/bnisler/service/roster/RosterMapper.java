package com.bnisler.service.roster;

import com.bnisler.dao.SeasonDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.dao.SplitDao;
import com.bnisler.dao.TeamDao;
import com.bnisler.entity.*;
import com.bnisler.service.MappingUtils;
import com.bnisler.service.player.PlayerDetail;
import com.bnisler.service.player.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RosterMapper {

    @Autowired
    private MappingUtils mappingUtils;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private SessionDao sessionDao;

    public void mapToEntity(RosterWriteRequest writeRequest, Roster roster) {
        mappingUtils.copyProperties(writeRequest, roster);
        Team team = teamDao.findTeamById(writeRequest.getTeamId());
        Session session = sessionDao.findSessionById(writeRequest.getSessionId());
        roster.setTeam(team);
        roster.setSession(session);
    }

    public void mapEntityToDetails(Roster roster, RosterDetail rosterDetail) {
        mappingUtils.copyProperties(roster, rosterDetail);
        rosterDetail.setTeamId(roster.getTeam().getId());
        rosterDetail.setTeamName(roster.getTeam().getName());
        rosterDetail.setSessionId(roster.getSession().getId());
        rosterDetail.setSessionYear(roster.getSession().getYear());
        rosterDetail.setSplitName(roster.getSession().getSplit().getName());
        rosterDetail.setSeasonName(roster.getSession().getSeason().getName());

        // todo : create a commitdetail object and commitmapper, use that instead of playerdetail object
        List<PlayerDetail> playerDetails = new ArrayList<>();
        for (Commit commit : roster.getCommits()) {
            PlayerDetail playerDetail = new PlayerDetail();
            playerMapper.mapEntityToDetail(commit.getPlayer(), playerDetail);
            playerDetails.add(playerDetail);
        }
        rosterDetail.setPlayers(playerDetails);
    }
}

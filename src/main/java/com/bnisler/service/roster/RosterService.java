package com.bnisler.service.roster;

import com.bnisler.dao.RosterDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Roster;
import com.bnisler.entity.Session;
import com.bnisler.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "rosterService")
@Transactional(readOnly = true)
public class RosterService {

    @Autowired
    private RosterDao rosterDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private RosterMapper rosterMapper;

    public List<RosterDetail> getAllRosters() {
        List<RosterDetail> rosterDetails = new ArrayList<>();
        for (Roster roster : rosterDao.findAllRosters()) {
            RosterDetail rosterDetail = new RosterDetail();
            rosterMapper.mapEntityToDetails(roster, rosterDetail);
            rosterDetails.add(rosterDetail);
        }
        return rosterDetails;
    }

    public Roster getRosterById(Long rosterId) {
        return rosterDao.findRosterById(rosterId);
    }

    public RosterDetail getRosterDetails(Long rosterId) {
        Roster roster = rosterDao.findRosterById(rosterId);
        RosterDetail rosterDetail = new RosterDetail();
        rosterMapper.mapEntityToDetails(roster, rosterDetail);
        return rosterDetail;
    }

    public List<RosterDetail> getAllRosterDetailsByTeamId(Long teamId) {
        Team team = teamDao.findTeamById(teamId);
        List<RosterDetail> rosterDetails = new ArrayList<>();
        for (Roster roster : team.getRosters()) {
            RosterDetail rosterDetail = new RosterDetail();
            rosterMapper.mapEntityToDetails(roster, rosterDetail);
            rosterDetails.add(rosterDetail);
        }
        return rosterDetails;
    }

    public List<RosterDetail> getAllRosterDetailsBySessionId(Long sessionId) {
        Session session = sessionDao.findSessionById(sessionId);
        List<RosterDetail> rosterDetails = new ArrayList<>();
        for (Roster roster : session.getRosters()) {
            RosterDetail rosterDetail = new RosterDetail();
            rosterMapper.mapEntityToDetails(roster, rosterDetail);
            rosterDetails.add(rosterDetail);
        }
        return rosterDetails;
    }

    @Transactional
    public Long createRoster(RosterWriteRequest writeRequest) {
        Roster roster = new Roster();
        rosterMapper.mapToEntity(writeRequest, roster);
        return rosterDao.saveRoster(roster);
    }

    @Transactional
    public void updateRoster(Long rosterId, RosterWriteRequest writeRequest) {
        Roster roster = rosterDao.findRosterById(rosterId);
        rosterMapper.mapToEntity(writeRequest, roster);
        rosterDao.updateRoster(roster);
    }
}

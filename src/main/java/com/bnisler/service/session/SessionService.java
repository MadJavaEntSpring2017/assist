package com.bnisler.service.session;

import com.bnisler.dao.SeasonDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.entity.Season;
import com.bnisler.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "sessionService")
@Transactional(readOnly = true)
public class SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private SessionMapper sessionMapper;

    public List<SessionDetail> getAllSessions() {
        List<SessionDetail> sessionDetails = new ArrayList<>();
        for (Session session : sessionDao.findAllSessions()) {
            SessionDetail sessionDetail = new SessionDetail();
            sessionMapper.mapEntityToDetail(session, sessionDetail);
            sessionDetails.add(sessionDetail);
        }
        return sessionDetails;
    }

    public Session getSessionById(Long sessionId) {
        return sessionDao.findSessionById(sessionId);
    }

    public SessionDetail getSessionDetails(Long sessionId) {
        Session session = sessionDao.findSessionById(sessionId);
        SessionDetail sessionDetail = new SessionDetail();
        sessionMapper.mapEntityToDetail(session, sessionDetail);
        return sessionDetail;
    }

    @Transactional
    public Long createSession(SessionWriteRequest writeRequest) {
        Session session = new Session();
        sessionMapper.mapToEntity(writeRequest, session);
        return sessionDao.saveSession(session);
    }

    @Transactional
    public void updateSession(Long sessionId, SessionWriteRequest writeRequest) {
        Session session = sessionDao.findSessionById(sessionId);
        sessionMapper.mapToEntity(writeRequest, session);
        sessionDao.updateSession(session);
    }

    public List<SessionDetail> getAllSessionDetailsBySeasonId(Long seasonId) {
        Season season = seasonDao.findSeasonById(seasonId);
        List<SessionDetail> sessionDetails = new ArrayList<>();
        for (Session session : season.getSessions()) {
            SessionDetail sessionDetail = new SessionDetail();
            sessionMapper.mapEntityToDetail(session, sessionDetail);
            sessionDetails.add(sessionDetail);
        }
        return sessionDetails;
    }
}

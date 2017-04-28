package com.bnisler.dao;

import com.bnisler.entity.Session;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sessionDao")
public class SessionDao extends AbstractDao<Long, Session> {

    @SuppressWarnings("unchecked")
    public List<Session> findAllSessions() {
        Criteria criteria = createEntityCriteria();
        return (List<Session>) criteria.list();
    }

    public Session findSessionById(Long sessionId) {
        return getByKey(sessionId);
    }

    public Long saveSession(Session session) {
        return save(session);
    }

    public void updateSession(Session session) {
        update(session);
    }
}

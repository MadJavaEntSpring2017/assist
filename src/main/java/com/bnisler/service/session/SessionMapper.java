package com.bnisler.service.session;

import com.bnisler.dao.SeasonDao;
import com.bnisler.dao.SessionDao;
import com.bnisler.dao.SplitDao;
import com.bnisler.entity.Season;
import com.bnisler.entity.Session;
import com.bnisler.entity.Split;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {

    @Autowired
    private MappingUtils mappingUtils;

    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private SplitDao splitDao;

    public void mapToEntity(SessionWriteRequest writeRequest, Session session) {
        Season season = seasonDao.findSeasonById(writeRequest.getSeasonId());
        session.setSeason(season);
        Split split = splitDao.findSplitById(writeRequest.getSplitId());
        session.setSplit(split);
    }

    public void mapEntityToDetail(Session session, SessionDetail sessionDetail) {
        sessionDetail.setSeasonName(session.getSeason().getName());
        sessionDetail.setSplitName(session.getSplit().getName());
    }
}

package com.bnisler.service;

import com.bnisler.entity.League;
import com.bnisler.dao.LeagueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LeagueService {

    @Autowired
    private LeagueDao leagueDao;

    public List<League> findAllLeagues() {
        return leagueDao.getAllLeagues();
    }
}

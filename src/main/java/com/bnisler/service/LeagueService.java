package com.bnisler.service;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
@Component
public class LeagueService {

    @Autowired
    private LeagueDao leagueDao;

    public List<League> findAllLeagues() {
        return leagueDao.getAllLeagues();
    }
}

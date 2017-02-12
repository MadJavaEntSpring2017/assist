package com.bnisler.service;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
@Service
@Transactional
public class LeagueService {

    @Autowired
    private LeagueDao leagueDao;

    public List<League> findAllLeagues() {
        return leagueDao.getAllLeagues();
    }
}

package com.bnisler.service.season;

import com.bnisler.dao.SeasonDao;
import com.bnisler.entity.Season;
import com.bnisler.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "seasonService")
@Transactional(readOnly = true)
public class SeasonService {

    @Autowired
    private SeasonDao seasonDao;

    @Autowired
    private SeasonMapper seasonMapper;

    public List<SeasonDetail> getAllSeasons() {
        List<SeasonDetail> seasonDetails = new ArrayList<>();
        for (Season season : seasonDao.findAllSeasons()) {
            SeasonDetail seasonDetail = new SeasonDetail();
            seasonMapper.mapEntityToDetail(season, seasonDetail);
            seasonDetails.add(seasonDetail);
        }
        return seasonDetails;
    }

    public Season getSeasonById(Long seasonId) {
        return seasonDao.findSeasonById(seasonId);
    }

    public SeasonDetail getSeasonDetails(Long seasonId) {
        Season season = seasonDao.findSeasonById(seasonId);
        SeasonDetail seasonDetail = new SeasonDetail();
        seasonMapper.mapEntityToDetail(season, seasonDetail);
        return seasonDetail;
    }

    @Transactional
    public Long createSeason(SeasonWriteRequest writeRequest) {
        Season season = new Season();
        seasonMapper.mapToEntity(writeRequest, season);
        return seasonDao.saveSeason(season);
    }

    @Transactional
    public void updateSeason(Long seasonId, SeasonWriteRequest writeRequest) {
        Season season = seasonDao.findSeasonById(seasonId);
        seasonMapper.mapToEntity(writeRequest, season);
        seasonDao.updateSeason(season);
    }
}

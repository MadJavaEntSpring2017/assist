package com.bnisler.dao;

import com.bnisler.entity.Season;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "seasonDao")
public class SeasonDao extends AbstractDao<Long, Season> {

    @SuppressWarnings("unchecked")
    public List<Season> findAllSeasons() {
        Criteria criteria = createEntityCriteria();
        return (List<Season>) criteria.list();
    }

    public Season findSeasonById(Long seasonId) {
        return getByKey(seasonId);
    }

    public Long saveSeason(Season season) {
        return save(season);
    }

    public void updateSeason(Season season) {
        update(season);
    }
}

package com.bnisler.service.season;

import com.bnisler.dao.SessionDao;
import com.bnisler.entity.Season;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeasonMapper {

    @Autowired
    private MappingUtils mappingUtils;

    @Autowired
    private SessionDao sessionDao;

    public void mapToEntity(SeasonWriteRequest writeRequest, Season season) {
        mappingUtils.copyProperties(writeRequest, season);
    }

    public void mapEntityToDetail(Season season, SeasonDetail seasonDetail) {
        mappingUtils.copyProperties(season, seasonDetail);

    }
}

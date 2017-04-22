package com.bnisler.service.team;

import com.bnisler.entity.Team;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    @Autowired
    private MappingUtils mappingUtils;

    public void mapToEntity(TeamWriteRequest writeRequest, Team team) {
        mappingUtils.copyProperties(writeRequest, team);
    }
}

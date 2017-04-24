package com.bnisler.service.player;

import com.bnisler.dao.TeamDao;
import com.bnisler.entity.Player;
import com.bnisler.entity.Team;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    @Autowired
    private MappingUtils mappingUtils;

    @Autowired
    private TeamDao teamDao;

    public void mapToEntity(PlayerWriteRequest writeRequest, Player player) {
        mappingUtils.copyProperties(writeRequest, player);
    }

    public void mapEntityToDetail(Player player, PlayerDetail playerDetail) {
        mappingUtils.copyProperties(player, playerDetail);
        if (player.getTeamId() != null) {
            Team team = teamDao.findTeamById(player.getTeamId());
            playerDetail.setTeam(team);
        }
    }
}

package com.bnisler.service.player;

import com.bnisler.entity.Player;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    @Autowired
    private MappingUtils mappingUtils;

    public void mapToEntity(PlayerWriteRequest writeRequest, Player player) {
        mappingUtils.copyProperties(writeRequest, player);
    }
}

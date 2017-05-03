package com.bnisler.service.commit;

import com.bnisler.dao.PlayerDao;
import com.bnisler.dao.RosterDao;
import com.bnisler.entity.Commit;
import com.bnisler.entity.Player;
import com.bnisler.service.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommitMapper {

    @Autowired
    private MappingUtils mappingUtils;

    public void mapEntityToDetail(Commit commit, CommitDetail commitDetail) {
        mappingUtils.copyProperties(commit, commitDetail);
        commitDetail.setPlayerId(commit.getPlayer().getId());
        commitDetail.setFirtname(commit.getPlayer().getFirstname());
        commitDetail.setLastname(commit.getPlayer().getLastname());
        commitDetail.setEmail(commit.getPlayer().getEmail());
    }
}

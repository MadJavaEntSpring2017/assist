package com.bnisler.service.roster;

import com.bnisler.entity.Commit;
import com.bnisler.entity.Player;
import com.bnisler.service.player.PlayerDetail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RosterDetail {
    private Long id;
    private Long teamId;
    private String teamName;
    private Long sessionId;
    private Integer sessionYear;
    private String splitName;
    private String seasonName;
    private List<PlayerDetail> players;
}

package com.bnisler.service.commit;

import com.bnisler.entity.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommitDetail {
    private Long playerId;
    private String firtname;
    private String lastname;
    private String email;
}
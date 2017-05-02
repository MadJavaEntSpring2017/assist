package com.bnisler.service.roster;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RosterWriteRequest {
    private Long sessionId;
    private Long teamId;
}

package com.bnisler.service.session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionWriteRequest {
    private Long seasonId;
    private Long splitId;
}

package com.bnisler.service.commit;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommitWriteRequest {
    private List<Long> playerIdList;
}

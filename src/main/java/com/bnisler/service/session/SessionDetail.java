package com.bnisler.service.session;

import com.bnisler.entity.Season;
import com.bnisler.entity.Split;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionDetail {
    private Long id;
    private Integer year;
    private Split split;
    private Season season;
}

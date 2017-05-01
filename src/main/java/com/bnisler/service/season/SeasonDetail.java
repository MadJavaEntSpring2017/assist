package com.bnisler.service.season;

import com.bnisler.entity.Session;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeasonDetail {
    private Long id;
    private String name;
    private boolean active;
    private List<Session> sessions;
}

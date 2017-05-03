package com.bnisler.controller;

import com.bnisler.entity.Roster;
import com.bnisler.service.commit.CommitService;
import com.bnisler.service.commit.CommitWriteRequest;
import com.bnisler.service.roster.RosterDetail;
import com.bnisler.service.roster.RosterService;
import com.bnisler.service.roster.RosterWriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController(value = "rosterController")
public class RosterController {

    @Autowired
    private RosterService rosterService;

    @Autowired
    private CommitService commitService;

    @RequestMapping(value = "/rosters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<RosterDetail> getAllRosters() {
        return rosterService.getAllRosters();
    }

    @RequestMapping(value = "/rosters", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public RosterDetail createRoster(@RequestBody RosterWriteRequest writeRequest) {
        Long rosterId = rosterService.createRoster(writeRequest);
        return rosterService.getRosterDetails(rosterId);
    }

    @RequestMapping(value = "/rosters/{rosterId}/commits", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Long createCommits(@PathVariable ("rosterId") Long rosterId,
                              @RequestBody CommitWriteRequest writeRequest) {
        commitService.createRosterCommits(rosterId, writeRequest);
        return rosterId;
    }
}

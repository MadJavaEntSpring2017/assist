package com.bnisler.controller;

import com.bnisler.entity.Roster;
import com.bnisler.service.roster.RosterDetail;
import com.bnisler.service.roster.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController(value = "rosterController")
public class RosterController {

    @Autowired
    private RosterService rosterService;

    @RequestMapping(value = "/rosters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<RosterDetail> getAllRosters() {
        return rosterService.getAllRosters();
    }
}

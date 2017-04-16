package com.bnisler.controller;

import com.bnisler.entity.Team;
import com.bnisler.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Team> getAllTeams() {
        return teamService.findAllTeams();
    }

    @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Team getTeamById(@PathVariable("teamId") int teamId) {
        return teamService.findTeamById(teamId);
    }

}

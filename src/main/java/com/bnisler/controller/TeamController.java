package com.bnisler.controller;

import com.bnisler.entity.Team;
import com.bnisler.service.roster.RosterDetail;
import com.bnisler.service.roster.RosterService;
import com.bnisler.service.team.TeamService;
import com.bnisler.service.team.TeamWriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private RosterService rosterService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Team> getAllTeams() {
        return teamService.findAllTeams();
    }

    @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Team getTeamById(@PathVariable("teamId") Long teamId) {
        return teamService.findTeamById(teamId);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Team createTeam(@RequestBody TeamWriteRequest writeRequest) {
        Long teamId = teamService.createTeam(writeRequest);
        return teamService.findTeamById(teamId);
    }

    @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public Team updateTeam(@PathVariable ("teamId") Long teamId,
                           @RequestBody TeamWriteRequest writeRequest) {
        teamService.updateTeam(teamId, writeRequest);
        return teamService.findTeamById(teamId);
    }

    @RequestMapping(value = "/teams/{teamId}/rosters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<RosterDetail> getAllRosterDetailsByTeamId(@PathVariable ("teamId") Long teamId) {
        return rosterService.getAllRosterDetailsByTeamId(teamId);
    }
}

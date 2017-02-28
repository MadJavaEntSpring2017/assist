package com.bnisler.controller;

import com.bnisler.entity.Team;
import com.bnisler.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView getAllTeams() {
        List<Team> teams = teamService.findAllTeams();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("teams");
        mv.addObject("teams", teams);

        return mv;
    }
}

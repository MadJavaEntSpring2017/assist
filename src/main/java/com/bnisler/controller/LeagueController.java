package com.bnisler.controller;

import com.bnisler.entity.League;
import com.bnisler.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @RequestMapping(value = "/leagues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<League> getAllLeagues() {
        return leagueService.findAllLeagues();
    }

//    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
//    public ModelAndView getAllLeagues() {
//        List<League> leagues = leagueService.findAllLeagues();
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("leagues");
//        mv.addObject("leagues", leagues);
//
//        return mv;
//    }
}
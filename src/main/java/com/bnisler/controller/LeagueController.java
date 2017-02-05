package com.bnisler.controller;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import com.bnisler.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ben on 2/4/2017.
 */
@Controller
public class LeagueController {

//    @Autowired
//    private LeagueService leagueService;

    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    public @ResponseBody League getAllLeagues() {
        League league = new League();
        league.setName("MAYSA");
        return league;

//        return leagueService.findAllLeagues();
    }
}

//@WebServlet(name = "LeagueController", urlPatterns = "/leagues")
//public class LeagueController extends HttpServlet {
//
//    @EJB
//    private LeagueService leagueService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<League> leagues = leagueService.findAllLeagues();
//        req.setAttribute("leagues", leagues);
//    }
//}

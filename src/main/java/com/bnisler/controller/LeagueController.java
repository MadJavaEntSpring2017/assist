package com.bnisler.controller;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;
import com.bnisler.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class LeagueController {

    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    public ModelAndView getAllLeagues() {
//        LeagueDao leagueDao = new LeagueDao();
        LeagueService leagueService = new LeagueService();
        List<League> leagues = leagueService.findAllLeagues();
//        List<League> leagues = leagueDao.getAllLeagues();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("leagues");
        mv.addObject("leagues", leagues);

        return mv;
    }
}

//@WebServlet(name = "LeagueController", urlPatterns = "/leagues")
//@WebServlet(urlPatterns = "/leagues")
//public class LeagueController extends HttpServlet {
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        LeagueDao leagueDao = new LeagueDao();
////        List<League> leagues = leagueService.findAllLeagues();
//        List<League> leagues = leagueDao.getAllLeagues();
//        req.setAttribute("leagues", leagues);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/leagues.jsp");
//        dispatcher.forward(req, res);
//    }
//}

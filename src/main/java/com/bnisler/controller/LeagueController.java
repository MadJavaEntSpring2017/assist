package com.bnisler.controller;

import com.bnisler.entity.League;
import com.bnisler.persist.LeagueDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "LeagueController", urlPatterns = "/leagues")
@WebServlet(urlPatterns = "/leagues")
public class LeagueController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        LeagueDao leagueDao = new LeagueDao();
//        List<League> leagues = leagueService.findAllLeagues();
        List<League> leagues = leagueDao.getAllLeagues();
        req.setAttribute("leagues", leagues);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/leagues.jsp");
        dispatcher.forward(req, res);
    }
}

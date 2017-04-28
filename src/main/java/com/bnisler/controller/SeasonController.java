package com.bnisler.controller;

import com.bnisler.entity.Season;
import com.bnisler.service.season.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @RequestMapping(value = "/seasons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @RequestMapping(value = "/seasons/{seasonId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Season getSeason(@PathVariable ("seasonId") Long seasonId) {
        return seasonService.getSeasonById(seasonId);
    }
}

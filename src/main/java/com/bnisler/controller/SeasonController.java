package com.bnisler.controller;

import com.bnisler.entity.Season;
import com.bnisler.service.season.SeasonDetail;
import com.bnisler.service.season.SeasonService;
import com.bnisler.service.season.SeasonWriteRequest;
import com.bnisler.service.session.SessionDetail;
import com.bnisler.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/seasons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<SeasonDetail> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @RequestMapping(value = "/seasons/{seasonId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Season getSeason(@PathVariable ("seasonId") Long seasonId) {
        return seasonService.getSeasonById(seasonId);
    }

    @RequestMapping(value = "/seasons/{seasonId}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public SeasonDetail getSeasonDetails(@PathVariable ("seasonId") Long seasonId) {
        return seasonService.getSeasonDetails(seasonId);
    }

    @RequestMapping(value = "/seasons", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Season createSeason(@RequestBody SeasonWriteRequest writeRequest) {
        Long seasonId = seasonService.createSeason(writeRequest);
        return seasonService.getSeasonById(seasonId);
    }

    @RequestMapping(value = "/seasons/{seasonId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public Season updateSeason(@PathVariable ("seasonId") Long seasonId,
                               @RequestBody SeasonWriteRequest writeRequest) {
        seasonService.updateSeason(seasonId, writeRequest);
        return seasonService.getSeasonById(seasonId);
    }

    @RequestMapping(value = "/seasons/{seasonId}/sessions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<SessionDetail> getAllSessionDetailsBySeasonId(@PathVariable ("seasonId") Long seasonId) {
        return sessionService.getAllSessionDetailsBySeasonId(seasonId);
    }
}

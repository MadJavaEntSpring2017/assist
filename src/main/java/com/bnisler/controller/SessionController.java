package com.bnisler.controller;

import com.bnisler.entity.Session;
import com.bnisler.service.roster.RosterDetail;
import com.bnisler.service.roster.RosterService;
import com.bnisler.service.session.SessionDetail;
import com.bnisler.service.session.SessionService;
import com.bnisler.service.session.SessionWriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController(value = "sessionController")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private RosterService rosterService;

    @RequestMapping(value = "/sessions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<SessionDetail> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @RequestMapping(value = "/sessions/{sessionId}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public SessionDetail getSessionDetails(@PathVariable ("sessionId") Long sessionId) {
        return sessionService.getSessionDetails(sessionId);
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Session createSession(@RequestBody SessionWriteRequest writeRequest) {
        Long sessionId = sessionService.createSession(writeRequest);
        return sessionService.getSessionById(sessionId);
    }

    @RequestMapping(value = "/sessions/{sessionId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public Session updateSession(@PathVariable ("sessionId") Long sessionId,
                                 @RequestBody SessionWriteRequest writeRequest) {
        sessionService.updateSession(sessionId, writeRequest);
        return sessionService.getSessionById(sessionId);
    }

    @RequestMapping(value = "/sessions/{sessionId}/rosters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<RosterDetail> getRosterDetailsBySessionId(@PathVariable ("sessionId") Long sessionId) {
        return rosterService.getAllRosterDetailsBySessionId(sessionId);
    }
}

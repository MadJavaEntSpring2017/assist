package com.bnisler.controller;

import com.bnisler.entity.Pitch;
import com.bnisler.service.PitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/pitches")
public class PitchController {

    @Autowired
    private PitchService pitchService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Pitch> getAllPitches() { return pitchService.findAllPitches(); }
}

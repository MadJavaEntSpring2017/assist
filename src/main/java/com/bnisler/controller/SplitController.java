package com.bnisler.controller;

import com.bnisler.service.split.SplitDetail;
import com.bnisler.service.split.SplitService;
import com.bnisler.service.split.SplitWriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController(value = "splitController")
public class SplitController {

    @Autowired
    private SplitService splitService;

    @RequestMapping(value = "/splits", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<SplitDetail> getAllSplits() {
        return splitService.getAllSplits();
    }

    @RequestMapping(value = "/splits/{splitId}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public SplitDetail getSplitDetails(@PathVariable ("splitId") Long splitId) {
        return splitService.getSplitDetails(splitId);
    }

    @RequestMapping(value = "/splits", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public SplitDetail createSplit(@RequestBody SplitWriteRequest writeRequest) {
        Long splitId = splitService.createSplit(writeRequest);
        return splitService.getSplitDetails(splitId);
    }

    @RequestMapping(value = "/splits/{splitId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public void updateSplit(@PathVariable ("splitId") Long splitId,
                            @RequestBody SplitWriteRequest writeRequest) {
        splitService.updateSplit(splitId, writeRequest);
    }
}

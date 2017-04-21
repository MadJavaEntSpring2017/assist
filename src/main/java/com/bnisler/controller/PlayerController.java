package com.bnisler.controller;

import com.bnisler.entity.Player;
import com.bnisler.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Player> getAllPlayers() { return playerService.findAllPlayers(); }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathVariable ("playerId") int playerId) { return playerService.findPlayerById(playerId); }
}
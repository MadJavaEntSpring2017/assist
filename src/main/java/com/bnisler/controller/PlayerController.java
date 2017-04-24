package com.bnisler.controller;

import com.bnisler.entity.Player;
import com.bnisler.service.player.PlayerDetail;
import com.bnisler.service.player.PlayerService;
import com.bnisler.service.player.PlayerWriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public List<Player> getAllPlayers() { return playerService.findAllPlayers(); }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Player getPlayer(@PathVariable ("playerId") Long playerId) { return playerService.findPlayerById(playerId); }

    @RequestMapping(value = "/players/{playerId}/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public PlayerDetail getPlayerDetails(@PathVariable ("playerId") Long playerId) {
        return playerService.findPlayerDetails(playerId);
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public Player createPlayer(@RequestBody PlayerWriteRequest writeRequest) {
        Long id = playerService.createPlayer(writeRequest);
        return playerService.findPlayerById(id);
    }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON)
    public Player updatePlayer(@PathVariable("playerId") Long playerId,
                               @RequestBody PlayerWriteRequest writeRequest) {
        playerService.updatePlayer(playerId, writeRequest);
        return playerService.findPlayerById(playerId);
    }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
    public void deletePlayer(@PathVariable ("playerId") Long playerId) {
        playerService.deletePlayer(playerId);
    }
}
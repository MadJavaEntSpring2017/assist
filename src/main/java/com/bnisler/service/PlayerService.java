package com.bnisler.service;

import com.bnisler.dao.PlayerDao;
import com.bnisler.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("playerService")
@Transactional(readOnly = true)
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public List<Player> findAllPlayers() {
        return playerDao.findAllPlayers();
    }

    public Player findPlayerById(int id) {
        return playerDao.findById(id);
    }
}

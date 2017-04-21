package com.bnisler.service.player;

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

    @Autowired
    private PlayerMapper playerMapper;

    public List<Player> findAllPlayers() {
        return playerDao.findAllPlayers();
    }

    public Player findPlayerById(int id) {
        return playerDao.findById(id);
    }

    @Transactional
    public int createPlayer(PlayerWriteRequest writeRequest) {
        Player player = new Player();
        playerMapper.mapToEntity(writeRequest, player);
        return playerDao.savePlayer(player);
    }

    @Transactional
    public void updatePlayer(int playerId, PlayerWriteRequest writeRequest) {
        Player player = playerDao.findById(playerId);
        playerMapper.mapToEntity(writeRequest, player);
        playerDao.updatePlayer(player); // todo: do i need to explicitly call update?
    }

    @Transactional
    public void deletePlayer(int playerId) {
        Player player = findPlayerById(playerId);
        playerDao.deletePlayer(player);
    }
}

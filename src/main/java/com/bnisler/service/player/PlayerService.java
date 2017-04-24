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

    public Player findPlayerById(Long id) {
        return playerDao.findById(id);
    }

    @Transactional
    public Long createPlayer(PlayerWriteRequest writeRequest) {
        Player player = new Player();
        playerMapper.mapToEntity(writeRequest, player);
        return playerDao.savePlayer(player);
    }

    @Transactional
    public void updatePlayer(Long playerId, PlayerWriteRequest writeRequest) {
        Player player = playerDao.findById(playerId);
        playerMapper.mapToEntity(writeRequest, player);
        playerDao.updatePlayer(player); // todo: do i need to explicitly call update?
    }

    @Transactional
    public void deletePlayer(Long playerId) {
        Player player = findPlayerById(playerId);
        playerDao.deletePlayer(player);
    }
}

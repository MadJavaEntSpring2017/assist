package com.bnisler.dao;

import com.bnisler.entity.Player;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")
public class PlayerDao extends AbstractDao<Long, Player> {

    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }

    public Player findById(Long id) {
        return getByKey(id);
    }

//    public void persistPlayer(Player player) {
//        persist(player);
//    }

    public Long savePlayer(Player player) {
        return save(player);
    }

    public void deletePlayer(Player player) {
        delete(player);
    }

    public void updatePlayer(Player player) {
        update(player);
    }
}

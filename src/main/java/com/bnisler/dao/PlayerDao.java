package com.bnisler.dao;

import com.bnisler.entity.Player;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")
public class PlayerDao extends AbstractDao<Integer, Player> {

    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }
}

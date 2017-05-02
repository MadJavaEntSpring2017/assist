package com.bnisler.dao;

import com.bnisler.entity.Roster;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "rosterDao")
public class RosterDao extends AbstractDao<Long, Roster> {

    @SuppressWarnings("unchecked")
    public List<Roster> findAllRosters() {
        Criteria criteria = createEntityCriteria();
        return (List<Roster>) criteria.list();
    }

    public Roster findRosterById(Long rosterId) {
        return getByKey(rosterId);
    }

    public Long saveRoster(Roster roster) {
        return save(roster);
    }

    public void deleteRoster(Roster roster) {
        delete(roster);
    }

    public void updateRoster(Roster roster) {
        update(roster);
    }
}

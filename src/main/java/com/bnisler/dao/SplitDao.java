package com.bnisler.dao;

import com.bnisler.entity.Split;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "splitDao")
public class SplitDao extends AbstractDao<Long, Split> {

    @SuppressWarnings("unchecked")
    public List<Split> findAllSplits() {
        Criteria criteria = createEntityCriteria();
        return (List<Split>) criteria.list();
    }

    public Split findSplitById(Long splitId) {
        return getByKey(splitId);
    }

    public Long saveSplit(Split split) {
        return save(split);
    }

    public void updateSplit(Split split) {
        update(split);
    }
}

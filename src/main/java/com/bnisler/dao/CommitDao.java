package com.bnisler.dao;

import com.bnisler.entity.Commit;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "commitDao")
public class CommitDao extends AbstractDao<Long, Commit> {

    @SuppressWarnings("unchecked")
    public List<Commit> findAllCommits(){
        Criteria criteria = createEntityCriteria();
        return (List<Commit>) criteria.list();
    }

    public Commit findCommitById(Long commitId) {
        return getByKey(commitId);
    }

    public Long saveCommit(Commit commit) {
        return save(commit);
    }

    public void saveAllCommits(List<Commit> commits) {
        if (commits != null && commits.size() > 0) {
            for (Commit commit : commits) {
                saveCommit(commit);
            }
        }
    }

    public void deleteCommit(Commit commit) {
        delete(commit);
    }

    public void deleteAll(List<Commit> commits) {
        if (commits != null && commits.size() > 0) {
            for (Commit commit : commits) {
                deleteCommit(commit);
            }
        }
    }

    public void updateCommit(Commit commit) {
        update(commit);
    }
}

package com.bnisler.service.commit;

import com.bnisler.dao.CommitDao;
import com.bnisler.dao.PlayerDao;
import com.bnisler.dao.RosterDao;
import com.bnisler.entity.Commit;
import com.bnisler.entity.Player;
import com.bnisler.entity.Roster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "commitService")
@Transactional(readOnly = true)
public class CommitService {

    @Autowired
    private CommitDao commitDao;

    @Autowired
    private CommitMapper commitMapper;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private RosterDao rosterDao;

    public List<CommitDetail> getAllCommitDetails() {
        List<CommitDetail> commitDetails = new ArrayList<>();
        for (Commit commit : commitDao.findAllCommits()) {
            CommitDetail commitDetail = new CommitDetail();
            commitMapper.mapEntityToDetail(commit, commitDetail);
            commitDetails.add(commitDetail);
        }
        return commitDetails;
    }

    @Transactional
    public void createRosterCommits(Long rosterId, CommitWriteRequest writeRequest) {
        Roster roster = rosterDao.findRosterById(rosterId);
        List<Commit> commits = roster.getCommits();

        //remove preexisting commits from db and roster entity
        commitDao.deleteAll(commits);
        roster.removeCommits(commits);

        //add commits coming in
        for (Long playerId : writeRequest.getPlayerIdList()) {
            Commit commit = new Commit();
            Player player = playerDao.findById(playerId);
            commit.setPlayer(player);
            commit.setRoster(roster);
            roster.addCommit(commit);
        }

        //save all the commits
        commitDao.saveAllCommits(roster.getCommits()); // todo : will i be ok if save is within loop within transaction?
    }

    public List<CommitDetail> getAllCommitDetailsByRosterId(Long rosterId) {
        Roster roster = rosterDao.findRosterById(rosterId);
        List<CommitDetail> commitDetails = new ArrayList<>();
        for (Commit commit : roster.getCommits()) {
            CommitDetail commitDetail = new CommitDetail();
            commitMapper.mapEntityToDetail(commit, commitDetail);
            commitDetails.add(commitDetail);
        }
        return commitDetails;
    }
}

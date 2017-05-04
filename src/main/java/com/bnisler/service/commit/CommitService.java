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
    public void deleteRosterCommits(Long rosterId) {
        Roster roster = rosterDao.findRosterById(rosterId);
        commitDao.deleteAll(roster.getCommits());
        roster.removeAllCommits();
        // todo : do i need to explicitly call .deleteAll()? if so, do i then need .removeAllCommits()?
    }

    @Transactional
    public void createRosterCommits(Long rosterId, CommitWriteRequest writeRequest) {
        Roster roster = rosterDao.findRosterById(rosterId);
        for (Long playerId : writeRequest.getPlayerIdList()) {
            Commit commit = new Commit();
            Player player = playerDao.findById(playerId);
            commit.setRoster(roster);
            commit.setPlayer(player);
            roster.addCommit(commit);
        }
        // todo : do i need to explicitly call .saveAllCommits()?
        commitDao.saveAllCommits(roster.getCommits());
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

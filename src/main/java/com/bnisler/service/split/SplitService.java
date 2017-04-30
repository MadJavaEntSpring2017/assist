package com.bnisler.service.split;

import com.bnisler.dao.SplitDao;
import com.bnisler.entity.Split;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "splitService")
@Transactional(readOnly = true)
public class SplitService {

    @Autowired
    private SplitDao splitDao;

    @Autowired
    private SplitMapper splitMapper;

    public List<SplitDetail> getAllSplits() {
        List<SplitDetail> splitDetails = new ArrayList<>();
        for (Split split : splitDao.findAllSplits()) {
            SplitDetail splitDetail = new SplitDetail();
            splitMapper.mapEntityToDetail(split, splitDetail);
            splitDetails.add(splitDetail);
        }
        return splitDetails;
    }

    public Split getSplit(Long splitId) {
        return splitDao.findSplitById(splitId);
    }

    public SplitDetail getSplitDetails(Long splitId) {
        Split split = splitDao.findSplitById(splitId);
        SplitDetail splitDetail = new SplitDetail();
        splitMapper.mapEntityToDetail(split, splitDetail);
        return splitDetail;
    }

    @Transactional
    public Long createSplit(SplitWriteRequest writeRequest) {
        Split split = new Split();
        splitMapper.mapToEntity(writeRequest, split);
        return splitDao.saveSplit(split);
    }

    @Transactional
    public void updateSplit(Long splitId, SplitWriteRequest writeRequest) {
        Split split = splitDao.findSplitById(splitId);
        splitMapper.mapToEntity(writeRequest, split);
        splitDao.updateSplit(split);
    }
}

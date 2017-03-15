package com.bnisler.service;

import com.bnisler.dao.PitchDao;
import com.bnisler.entity.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PitchService {

    @Autowired
    private PitchDao pitchDao;

    public List<Pitch> findAllPitches() { return pitchDao.getAllPitches(); }
}

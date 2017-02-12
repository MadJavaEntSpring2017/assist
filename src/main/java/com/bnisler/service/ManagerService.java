package com.bnisler.service;

import com.bnisler.entity.Manager;
import com.bnisler.persist.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ben on 2/12/2017.
 */
@Service
@Transactional
public class ManagerService {

    @Autowired
    private ManagerDao managerDao;

    public List<Manager> findAllManagers() {
        return managerDao.getAllManagers();
    }
}

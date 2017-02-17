package com.bnisler.service;

import com.bnisler.entity.Manager;
import com.bnisler.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ManagerService {

    @Autowired
    private ManagerDao managerDao;

    public List<Manager> findAllManagers() {
        return managerDao.getAllManagers();
    }

    public Manager findManagerById(int id) {
        return managerDao.getManagerById(id);
    }
}

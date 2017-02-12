package com.bnisler.controller;

import com.bnisler.entity.Manager;
import com.bnisler.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ben on 2/12/2017.
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView getAllManagers() {
        List<Manager> managers = managerService.findAllManagers();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("managers");
        mv.addObject("managers", managers);

        return mv;
    }
}

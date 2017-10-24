package com.xingyun.smartsite.service.impl;

import com.xingyun.smartsite.model.MenuNode;
import com.xingyun.smartsite.dao.SmartsiteMainDao;
import com.xingyun.smartsite.service.SmartsiteMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartsiteMainsServiceImpl implements SmartsiteMainService {

    @Autowired
    SmartsiteMainDao dao;
    @Override
    public List<MenuNode> getAllNormalMenuNode() throws Exception {
        return dao.getAllNormalMenuNode();
    }

    @Override
    public List<MenuNode> getNormalMenuNodeByUser(String uid) throws Exception {
        return dao.getNormalMenuNodeByUser(uid);
    }
}

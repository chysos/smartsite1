package com.xingyun.smartsite.service.Engineering.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EngineeringFloorServiceImp implements EngineeringFloorService {
    @Autowired
    EngineeringFloorDao photoDao;
    @Override
    public List<EngineeringFloorModel> getFloor(Map<String, String> select) {
        return photoDao.getFloor(select);
    }
}

package com.xingyun.smartsite.service.Engineering.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EngineeringScheduleServiceImp implements EngineeringScheduleService{
    @Autowired
    EngineeringScheduleDao dao;

    @Override
    public List<EngineeringScheduleModel> getSchedule(Map<String, String> select) {
        return dao.getSchedule(select);
    }
}

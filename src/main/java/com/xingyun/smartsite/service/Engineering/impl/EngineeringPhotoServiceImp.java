package com.xingyun.smartsite.service.Engineering.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class EngineeringPhotoServiceImp implements EngineeringPhotoService {
    @Autowired
    EngineeringPhotoDao photoDao;
    @Override
    public List<EngineeringPhotoModel> getPhoto(Map<String, String> select) {
        return photoDao.getPhoto(select);
    }
}

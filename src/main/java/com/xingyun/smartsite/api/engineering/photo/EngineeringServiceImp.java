package com.xingyun.smartsite.api.engineering.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class EngineeringServiceImp implements  EngineeringService{
    @Autowired
    EngineeringPhotoDao photoDao;
    @Override
    public List<EngineeringPhotoModel> getPhoto(Map<String, String> select) {
        return photoDao.getPhoto(select);
    }
}

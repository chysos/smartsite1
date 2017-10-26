package com.xingyun.smartsite.api.engineering.photo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EngineeringService {
    List<EngineeringPhotoModel> getPhoto(Map<String,String> select);
}

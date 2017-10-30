package com.xingyun.smartsite.service.Engineering;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EngineeringFloorService {
    List<EngineeringFloorModel> getFloor(Map<String, String> select);
}

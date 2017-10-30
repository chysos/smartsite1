package com.xingyun.smartsite.service.Engineering;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EngineeringScheduleService {
    List<EngineeringScheduleModel> getSchedule(Map<String,String> select);
}

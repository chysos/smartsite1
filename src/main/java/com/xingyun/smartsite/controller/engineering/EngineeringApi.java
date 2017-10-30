package com.xingyun.smartsite.controller.engineering;

import com.xingyun.smartsite.controller.engineering.floor.EngineeringFloorModel;
import com.xingyun.smartsite.controller.engineering.floor.EngineeringFloorService;
import com.xingyun.smartsite.controller.engineering.photo.EngineeringPhotoModel;
import com.xingyun.smartsite.controller.engineering.photo.EngineeringPhotoService;
import com.xingyun.smartsite.controller.engineering.schedule.EngineeringScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:曹彬彬
 * date：2017/10/26
 */
@RequestMapping(value = "/gk")
@Controller
public class EngineeringApi {
    @Autowired
    EngineeringPhotoService engineeringPhotoService;

    @Autowired
    EngineeringFloorService engineeringFloorService;

    //项目图片
    @RequestMapping(value = "picture", method = RequestMethod.GET)
    @ResponseBody
    public List<EngineeringPhotoModel> getEngineeringPic(
            @RequestParam(value = "endTime") String endTime,
            @RequestParam(value = "projectId") String projectId,
            @RequestParam(value = "startTime") String startTime) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("endTime", endTime);
        params.put("startTime", startTime);
        params.put("projectId", projectId);

        return engineeringService.getPhoto(params);
    }

    /**
     * 项目计划
     */

    @RequestMapping(value = "taskList", method = RequestMethod.GET)
    @ResponseBody
    public List<EngineeringScheduleModel> getEngineeringSchedule(@RequestParam(value = "projectId") String projectId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("projectId", projectId);
        return engineeringScheduleService.getSchedule(params);
    }

    /**
     *项目楼层清单
     */
    @RequestMapping(value="floorList",method=RequestMethod.GET)
    @ResponseBody
    public List<EngineeringFloorModel> getFloorList(@RequestParam(value = "projectId") String projectId){
        Map<String, String> params = new HashMap<String, String>();
        params.put("projectId", projectId);
        return engineeringFloorService.getFloor(params);

    }

}

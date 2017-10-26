package com.xingyun.smartsite.api.engineering;

import com.xingyun.smartsite.api.engineering.photo.EngineeringPhotoModel;
import com.xingyun.smartsite.api.engineering.photo.EngineeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/gk")
@Controller
public class EngineeringApi {
    @Autowired
    EngineeringService engineeringService;
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


}

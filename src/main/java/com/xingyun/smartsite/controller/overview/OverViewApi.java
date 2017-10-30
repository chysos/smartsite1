package com.xingyun.smartsite.controller.overview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/zl")
@Controller
public class OverViewApi {
    @RequestMapping(value = "/totalFee", method = RequestMethod.GET)
    @ResponseBody
    public String getTotalFee(@RequestParam(value = "projctId") String projctId, @RequestParam(value = "userId", required = false, defaultValue = "") String userId) {
        return "";
    }
}

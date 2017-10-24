package com.xingyun.smartsite.controller;

import com.xingyun.smartsite.common.property.CommonProperties;
import com.xingyun.smartsite.model.ProcessReason;
import com.xingyun.smartsite.service.ProcessReasonService;

import com.xingyun.smartsite.utils.CommonUtil;
import com.xingyun.smartsite.utils.DateConvert;

//import com.xingyun.smartsite.utils.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * User:崔弘杨
 * Date:2017/10/12
 * Time:17:11
 */
@RequestMapping(value = "/inout")
@Controller

public class ProcessReasonController {
    private final Log logger =LogFactory.getLog(this.getClass());
    @Autowired
    ProcessReasonService processReasonService;
    @RequestMapping(value = "/getReasonInfo",method = RequestMethod.POST)
    @ResponseBody
    public Model getReasonInfo(Model model, HttpSession session, HttpServletRequest request){

        String type = request.getParameter("type");
        String comments = request.getParameter("comments");
        String create_time = request.getParameter("create_time");
        String create_user = request.getParameter("create_time");
        String reason = request.getParameter("reason");

        ProcessReason processReason=new ProcessReason();
        processReason.setType(type);
        processReason.setComments(comments);
       // processReason.setCtime(DateConvert.StrToDate(ctime));
        processReason.setCreate_user(create_user);
        processReason.setReason(reason);
        try {
            List<ProcessReason> pro = processReasonService.getTestProcessReasonInfo(processReason);
            model.addAttribute("total", 40);
            model.addAttribute("data", pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
//查询单条
@RequestMapping(value = "/getTestOneReasonInfo",method = RequestMethod.POST)
@ResponseBody
public Model getTestOneReasonInfo(Model model, HttpSession session, HttpServletRequest request){
    String  sid= request.getParameter("id");
//    String type = request.getParameter("type");
//    String comments = request.getParameter("comments");
//    String ctime = request.getParameter("ctime");
//    String cuser = request.getParameter("cuser");
//    String reason = request.getParameter("reason");

    ProcessReason processReason=new ProcessReason();
    int   id = Integer.parseInt(sid);
     processReason.setId(id);
//    processReason.setType(type);
//    processReason.setComments(comments);
//    // processReason.setCtime(DateConvert.StrToDate(ctime));
//    processReason.setCuser(cuser);
//    processReason.setReason(reason);
    try {
       ProcessReason pro = processReasonService.getTestOneProcessReasonInfo(processReason);
        model.addAttribute("resultCode", CommonProperties.getProperty("success.code"));
        model.addAttribute("resultData" ,pro);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return model;
}
    //增加
    @RequestMapping(value = "/creatReasonInfo",method = RequestMethod.POST)
    @ResponseBody
    public Model creatReasonInfo(Model model, HttpSession session, HttpServletRequest request){
//        User us = (User) session.getAttribute("user");
        String mydata = request.getParameter("data");
        ProcessReason processReason = (ProcessReason) JSONObject.toBean(JSONObject.fromObject(mydata), ProcessReason.class);
        try {
             processReasonService.creatProcessReasonInfo(processReason);
            model.addAttribute("resultCode", CommonProperties.getProperty("success.code"));
            model.addAttribute("resultData", "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
     //修改
     @RequestMapping(value = "/updateReasonInfo",method = RequestMethod.POST)
     @ResponseBody
     public Model updateReasonInfo(Model model, HttpSession session, HttpServletRequest request                      ){
//        User us = (User) session.getAttribute("user");
         String mydata = request.getParameter("data");
         ProcessReason processReason = (ProcessReason) JSONObject.toBean(JSONObject.fromObject(mydata), ProcessReason.class);
         try {
             processReasonService.updateProcessReasonInfo(processReason);
             model.addAttribute("resultCode", CommonProperties.getProperty("success.code"));
             model.addAttribute("resultData", "修改成功");
         } catch (Exception e) {
             e.printStackTrace();
         }
         return model;
     }
     //删除
     @RequestMapping(value = "/deleteReasonInfo",method = RequestMethod.POST)
     @ResponseBody
     public Model deleteReasonInfo(Model model, HttpSession session, HttpServletRequest request                      ){
//        User us = (User) session.getAttribute("user");
         String mydata = request.getParameter("data");
//         ProcessReason processReason = (ProcessReason) JSONObject.toBean(JSONObject.fromObject(mydata), ProcessReason.class);

//         ProcessReason processReason=new ProcessReason();
//         processReason.setType(type);
//         processReason.setComments(comments);
//         Date obj = DateConvert.StrToDate(creat_time);
//         processReason.setCreate_time(obj);
//         processReason.setCreate_user(creat_user);
//         processReason.setReason(reason);
         try {
             processReasonService.deleteReasonInfo(mydata);
             model.addAttribute("resultCode", CommonProperties.getProperty("success.code"));
             model.addAttribute("resultData", "修改成功");
         } catch (Exception e) {
             e.printStackTrace();
         }
         return model;
     }



}

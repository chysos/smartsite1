package com.xingyun.smartsite.controller.project;

import com.xingyun.smartsite.model.Project.Project;
import com.xingyun.smartsite.service.ProjectService.ProjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User:崔弘杨
 * Date:2017/10/24
 * Time:17:34
 */
@RequestMapping(value = "/project")
@Controller
public class ProjectController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/getProjectInfo", method = RequestMethod.GET)
    @ResponseBody
    public Model getProjectInfo(Model model, HttpSession session, HttpServletRequest request, @RequestParam String projectId) {
        List<Project> list = null;
        Integer proj33ectId = Integer.parseInt(projectId);
        try {
            Project project = new Project();
            project.setProjectId(proj33ectId);


            list = projectService.getProjectList(project);
            int count = list.size();
            model.addAttribute("data", list);
            model.addAttribute("total", count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
}

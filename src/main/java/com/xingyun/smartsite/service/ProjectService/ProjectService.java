package com.xingyun.smartsite.service.ProjectService;

import com.xingyun.smartsite.model.Project.Project;

import java.util.List;


public interface ProjectService {
    List<Project> getProjectList(Project projectInfo) throws Exception;

//    Project getById(int id) throws Exception;
//
//    void deleteProject(String ids) throws Exception;
//
//    void insertProjectInfo(Project projectInfo) throws Exception;
//
//    void updateProjectInfo(Project projectInfo) throws Exception;

}

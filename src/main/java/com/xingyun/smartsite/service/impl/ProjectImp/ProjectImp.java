package com.xingyun.smartsite.service.impl.ProjectImp;

import com.xingyun.smartsite.dao.ProjectDao.ProjectDao;
import com.xingyun.smartsite.model.Project.Project;
import com.xingyun.smartsite.service.ProjectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User:崔弘杨
 * Date:2017/10/25
 * Time:15:13
 */
@Service
public class ProjectImp implements ProjectService {


        @Autowired
        ProjectDao dao;


        @Override
        public List<Project> getProjectList(Project project) throws Exception {

            return dao.getProjectList(project);
        }


    }


package com.xingyun.smartsite.dao.ProjectDao;


import com.xingyun.smartsite.common.dao.CommonDao;
import com.xingyun.smartsite.model.Project.Project;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDao extends CommonDao {

    public List<Project> getProjectList(Project projectInfo){
        SqlSession session=getSqlSession();
        return  session.selectList("projectInfo.getProjectList",projectInfo);
    }

    public Project getById(int id){
        SqlSession session=getSqlSession();
        return session.selectOne("projectInfo.getById",id);
    }

    public void insertProject(Project projectInfo){
        SqlSession session=getSqlSession();
       session.insert("projectInfo.insertPro",projectInfo);
    }

    public  void deleteProject(String id){
        SqlSession session=getSqlSession();
        session.update("projectInfo.deleteById",id);
    }

    public void updatePro(Project projectInfo){
        SqlSession session=getSqlSession();
        session.update("projectInfo.updatePro",projectInfo);
    }


}

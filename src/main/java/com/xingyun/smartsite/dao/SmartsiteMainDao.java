package com.xingyun.smartsite.dao;
import com.xingyun.smartsite.common.dao.CommonDao;
import com.xingyun.smartsite.model.MenuNode;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 */
@Repository
public class SmartsiteMainDao extends CommonDao{
    public List<MenuNode> getAllNormalMenuNode() {
        SqlSession session = getSqlSession();
        return session.selectList("smartsite.getMenuNode");
    }

    public List<MenuNode> getNormalMenuNodeByUser(String uid) {
        return null;
    }




}

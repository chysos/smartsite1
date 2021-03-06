package com.xingyun.smartsite.dao.Engineering;

import com.xingyun.smartsite.common.dao.CommonDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EngineeringFloorDao extends CommonDao {
    public List<EngineeringFloorModel> getFloor(Map<String,String> select){
        SqlSession session = getSqlSession();
        return session.selectList("projectSchedule.findSchedule", select);
    }

}

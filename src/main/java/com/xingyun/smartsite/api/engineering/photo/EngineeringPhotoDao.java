package com.xingyun.smartsite.api.engineering.photo;

import com.xingyun.smartsite.common.dao.CommonDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EngineeringPhotoDao extends CommonDao {
    public List<EngineeringPhotoModel> getPhoto(Map<String,String> select){
        SqlSession session = getSqlSession();
        return session.selectList("schedulePhoto.findSchedulePhoto", select);
    }

}

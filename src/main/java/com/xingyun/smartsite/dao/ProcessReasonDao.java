package com.xingyun.smartsite.dao;

import com.xingyun.smartsite.common.dao.CommonDao;
import com.xingyun.smartsite.model.ProcessReason;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User:崔弘杨
 * Date:2017/10/12
 * Time:17:40
 */
@Repository
public class ProcessReasonDao extends CommonDao {

    public List<ProcessReason> getTestProcessReasonInfo(ProcessReason processReason) {
        SqlSession session = getSqlSession();
        return session.selectList("reason.getTestInfo", processReason);
    }

    public void updateProcessReasonInfo(ProcessReason processReason) {
        SqlSession session = getSqlSession();
        session.update("reason.updateInfo", processReason);
    }

    public void creatProcessReasonInfo(ProcessReason processReason) {
        SqlSession session = getSqlSession();
        session.insert("reason.creatInfo", processReason);
    }
    public ProcessReason getTestOneProcessReasonInfo(ProcessReason processReason) {
        SqlSession session = getSqlSession();
        return session.selectOne("reason.getTestOneInfo", processReason);
    }

    public void deleteReasonInfo(ProcessReason processReason) {
        SqlSession session = getSqlSession();
       session.update("reason.deleteReasonInfo", processReason);
    }
}

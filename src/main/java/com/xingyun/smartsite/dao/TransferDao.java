package com.xingyun.smartsite.dao;

import com.xingyun.smartsite.common.dao.CommonDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository

public class TransferDao extends CommonDao {
    public List<Map<String,Object>> getTQusList(){
        SqlSession session = getSqlSession();
        return session.selectList("transfer.getTQusList");
    }
    public List<Map<String,Object>> getTQscList(List<String> codes){
        SqlSession session = getSqlSession();
        return session.selectList("transfer.getTQscList",codes);
    }
    public List<Map<String,Object>> getTQsdList(List<String> codes){
        SqlSession session = getSqlSession();
        return session.selectList("transfer.getTQsdList",codes);
    }
    public int insertLog(String uid){
        SqlSession session = getSqlSession();
        return session.insert("transfer.insertLog",uid);
    }
    public int updateLogStep(Map<String,Object> map){
        SqlSession session = getSqlSession();
        return session.update("transfer.updateLogStep",map);
    }

    public int insertQusList(List<Map<String,Object>> lm){
        SqlSession session = getSqlSession();
        return session.insert("transfer.insertQusList",lm);
    }
    public int insertQscList(List<Map<String,Object>> lm){
        SqlSession session = getSqlSession();
        return session.insert("transfer.insertQscList",lm);
    }
    public int insertQsdList(List<Map<String,Object>> lm){
        SqlSession session = getSqlSession();
        return session.insert("transfer.insertQsdList",lm);
    }
    public int insertLesList(List<Map<String,Object>> lm){
        SqlSession session = getSqlSession();
        return session.insert("transfer.insertLesList",lm);
    }

    public int updateQusImportFlag(List<String> codes){
        SqlSession session = getSqlSession();
        return session.update("transfer.updateQusImportFlag",codes);
    }
    public int updateQscImportFlag(List<String> codes){
        SqlSession session = getSqlSession();
        return session.update("transfer.updateQscImportFlag",codes);
    }
    public int updateQsdImportFlag(List<String> codes){
        SqlSession session = getSqlSession();
        return session.update("transfer.updateQsdImportFlag",codes);
    }
}

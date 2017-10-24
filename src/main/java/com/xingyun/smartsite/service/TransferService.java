package com.xingyun.smartsite.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TransferService {

    public List<Map<String,Object>> getTQusList() throws Exception;
    public List<Map<String,Object>> getTQscList(List<String> codes) throws Exception;
    public List<Map<String,Object>> getTQsdList(List<String> codes) throws Exception;

    public int updateLogStep(Map<String,Object> map) throws Exception;
    public int updateImportFlag(List<String> codes);
    public int insertLog(String uid) throws Exception;

    public int insertQusList(List<Map<String,Object>> lm) throws Exception;
    public int insertQscList(List<Map<String,Object>> lm) throws Exception;
    public int insertQsdList(List<Map<String,Object>> lm) throws Exception;
    public int insertLesList(List<Map<String,Object>> lm) throws Exception;
}

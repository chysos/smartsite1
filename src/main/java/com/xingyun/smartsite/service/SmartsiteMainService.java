package com.xingyun.smartsite.service;
import com.xingyun.smartsite.model.MenuNode;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * USER:haoranxu DATE:2017/9/14 TIME:15:27
 */
public interface SmartsiteMainService {

    // 获取所有菜单
    public List<MenuNode> getAllNormalMenuNode() throws Exception;

    // 通过用户获取权限范围内的菜单
    public List<MenuNode> getNormalMenuNodeByUser(String uid) throws Exception;

}

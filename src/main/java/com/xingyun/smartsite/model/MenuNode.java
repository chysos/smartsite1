package com.xingyun.smartsite.model;

import lombok.Data;

import java.util.List;

/***
 *USER:haoranxu
 *DATE:2017/9/14
 *TIME:14:30    系统菜单节点项
 */
@Data
public class MenuNode implements Comparable<MenuNode>{
    private int id;
    private int rankId;//级别id，在页面中的显示层级
    private int pid;
    private String name;
    private int sequence;//在页面中的显示顺序
    private List<MenuNode> childes;
    private String typeCode;//菜单类型，1为普通菜单，2为按钮。
    private String htmlName;//菜单对应的页面名
    private int hasChild;



    @Override
    public int compareTo(MenuNode o) {
        return this.sequence-o.sequence;
    }


}

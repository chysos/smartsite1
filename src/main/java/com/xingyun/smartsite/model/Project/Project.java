package com.xingyun.smartsite.model.Project;

import lombok.Data;

/**
 * User:崔弘杨
 * Date:2017/10/24
 * Time:17:44
 */
@Data
public class Project {
    private int id;//

    private int projectId;//

    private String name;//工程名称

    private String area;//工程区域

    private String addr;//工程地点

    private String scale;//规模性质

    private String invest;//投资类型

    private String structure;//产业构成

    private String qualification;//专业资质

    private double cost;//工程造价（万元）

    private String contractDate;//合同日期

    private double construction_area;//建筑面积（m2）

    private String startTime;//开工日期

    private String status;//项目状态



    private String owner_unit;//业主单位

    private String construction_unit;//建设单位

    private String design_unit;//设计单位

    private String supervision_unit;//监理单位

    private String bulider_unit;//施工单位

    private double dday;//偏差天数

    private double water_target;//目标水量

    private double electricity_target;//目标电量

    private String content;//内容

    private String create_time;//创建日期

    private String create_user;//创建人

    private String comments;//备注

    private int is_del;//删除标志

    private String modify_time;//修改时间

    private String modify_user;//修改人

    private String finishTime;//竣工日期

    private String photo;//项目图片
}

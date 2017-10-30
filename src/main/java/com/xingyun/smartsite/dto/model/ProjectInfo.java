package com.xingyun.smartsite.dto.model;

import lombok.Data;
/**
 * author:曹彬彬
 * time:2017/10/27
 * 项目工程
 */
@Data
public class ProjectInfo {
    private Integer construction_area;//建筑面积
    private String builder_unit;//施工单位
    private String content;//详细信息
    private String contrac_date;//合同日期
    private String design_unit;//设计单位
    private String end_date;//竣工日期
    private String photo;//主页图片
    private String name;//项目名称
    private String qualification;//专业资质
    private String scale;//项目性质
    private String begin_date;//开工时间
    private String supervision_unit;//监理单位
    private String invest;//投资类型

}

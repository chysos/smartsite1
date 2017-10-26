package com.xingyun.smartsite.api.engineering.schedule;

import lombok.Data;

@Data
public class EngineeringScheduleModel {
    private String deviation;//偏差分析
    private String planStart;//计划开始时间
    private String plantFinish;//计划结束时间
    private String progressState; //进度状态
    private String realFinish;//实际结束时间
    private String realStart;//实际开始时间
    private String reason;//原因
    private String state;//任务状态
    private String title;//标题
}

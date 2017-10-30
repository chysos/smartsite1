package com.xingyun.smartsite.dto.model;

import lombok.Data;

/**
 * author:曹彬彬
 * time:2017/10/27
 * 项目计划
 */
@Data
public class Complete {
    private String deviation;//偏差分析
    private String begin_date_plan;//计划开始时间
    private String end_date_plan;//计划结束时间
    private String process_status;//进度状态
    private String end_date_actual;//实际结束时间
    private String begin_date_actual;//实际开始时间
    private String reason;//原因
    private String status;//任务状态
    private String name;//标题
}

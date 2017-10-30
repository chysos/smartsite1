package com.xingyun.smartsite.dto.model;

import com.xingyun.smartsite.dto.ResultModel;
import lombok.Data;
/**
 * author:曹彬彬
 * time:2017/10/27
 * 项目图片
 */
@Data
public class SchCompletePhoto extends ResultModel {
    private String describe;//描述
    private String photo;//路径
    private String name;//所属区域(任务名称)
    private String temperature;//温度
    private String ptime;//上传时间
    private String puser;//上传人
    private String weather;//天气
    private String wind;//风力
}

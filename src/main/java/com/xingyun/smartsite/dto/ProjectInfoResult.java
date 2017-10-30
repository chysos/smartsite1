package com.xingyun.smartsite.dto;

import com.xingyun.smartsite.dto.model.ProjectInfo;
import lombok.Data;
/**
 * author:曹彬彬
 * time:2017/10/27
 * 项目工程结果
 */
@Data
public class ProjectInfoResult extends ResultModel {
    private ProjectInfo projectInfo;
}

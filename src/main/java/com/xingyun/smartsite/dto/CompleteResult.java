package com.xingyun.smartsite.dto;

import com.xingyun.smartsite.dto.model.Complete;
import lombok.Data;

import javax.naming.spi.DirStateFactory;
/**
 * author:曹彬彬
 * time:2017/10/27
 * 项目计划结果
 */
@Data
public class CompleteResult extends ResultModel {
    private Complete complete;
}

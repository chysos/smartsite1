package com.xingyun.smartsite.dto;

import com.xingyun.smartsite.dto.model.Hydropower;
import lombok.Data;
/**
 * author:曹彬彬
 * time:2017/10/27
 * 水量、电量结果
 */
@Data
public class HydropowerResult extends ResultModel {
    private Hydropower hydropower;
}

package com.xingyun.smartsite.dto;

import com.xingyun.smartsite.dto.model.DevicePosition;
import lombok.Data;

/**
 * author:曹彬彬
 * time:2017/10/27
 *塔基监控 或者 噪音监控
 */
@Data
public class CraneOrPmdetectPositionResult extends ResultModel{
    private DevicePosition devicePosition;//设备
}

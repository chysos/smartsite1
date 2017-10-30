package com.xingyun.smartsite.dto;

import com.xingyun.smartsite.dto.model.DevicePosition;
import lombok.Data;

import java.util.List;

/**
 * author:曹彬彬
 * time：2017/10/27
 * 升降机监控    视频监控
 */
@Data
public class LiftPositionResult extends ResultModel{
    private List<DevicePosition> devicePositionList;
}

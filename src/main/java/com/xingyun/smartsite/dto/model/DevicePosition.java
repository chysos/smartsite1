package com.xingyun.smartsite.dto.model;

import lombok.Data;

/**
 * author:曹彬彬
 * time:2017/10/27
 * 设备
 */
@Data
public class DevicePosition {
    private Integer id;//设备id
    private Integer type;//类型（施工现场、生活区）
    private Integer left; // 靠左边多少
    private Integer top;//靠右多少
}

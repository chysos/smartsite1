package com.xingyun.smartsite.dto;


import lombok.Data;

/**
 * 对接MIniUI的Menu菜单
 */
@Data

public class MiniMenu {
    private String id;
    private String pid;
    private String text;
    private String htmlName;
}

package com.xingyun.smartsite.model;
import lombok.Data;

import java.util.Date;

@Data
public class ProcessReason {

    private int id;
    private String type;
    private String reason;
    private String comments;
    private Date create_time;
    private String create_user;
    private  int is_del;
    private Date modify_time;
    private String modify_user;
}

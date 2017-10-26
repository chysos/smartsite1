package com.xingyun.smartsite.api.engineering.photo;

import lombok.Data;

@Data
public class EngineeringPhotoModel {
    private String des;
    private String imgPath;
    private String location;
    private String temp;
    private String uploadTime;
    private String user;
    private String weather;
    private String wind;
}

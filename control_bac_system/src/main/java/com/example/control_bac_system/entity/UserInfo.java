package com.example.control_bac_system.entity;

import lombok.Data;

@Data
public class UserInfo {

    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String updateTime;
    private String createTime;
}

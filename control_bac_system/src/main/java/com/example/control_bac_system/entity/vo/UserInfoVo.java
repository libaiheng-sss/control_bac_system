package com.example.control_bac_system.entity.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Integer status;
    private String updateTime;
    private String createTime;
}

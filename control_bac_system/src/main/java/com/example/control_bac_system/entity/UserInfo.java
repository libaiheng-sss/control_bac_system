package com.example.control_bac_system.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserInfo {

    private Integer id;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private Integer status;
    private String updateTime;
    private String createTime;
}

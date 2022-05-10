package com.example.control_bac_system.entity;


import lombok.Data;

import java.util.List;

@Data
public class UserInfoVo {

    private String username;
    private List<String> roles;
    private String avatar;
    private String introduction;
}

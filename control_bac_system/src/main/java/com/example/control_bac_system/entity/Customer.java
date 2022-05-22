package com.example.control_bac_system.entity;

import lombok.Data;

@Data
public class Customer {

    private Integer id;
    private String customerId;
    private String username;
    private String phoneNumber;
    private String email;
    private String province;
    private String city;
    private String district;
    private String detailedAddress;
    private String description;
    private Integer userId; // 对接人
    private Integer status; // 对接人
    private Integer gender;
    private String updateTime;
    private String createTime;

}

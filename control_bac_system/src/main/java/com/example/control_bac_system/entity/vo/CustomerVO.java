package com.example.control_bac_system.entity.vo;

import lombok.Data;

@Data
public class CustomerVO {

    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String province;
    private String city;
    private String district;
    private String detailedAddress;
    private String description;
    private String username; // 对接人
    private String status;
    private String userId;
    private String updateTime;
    private String createTime;
}

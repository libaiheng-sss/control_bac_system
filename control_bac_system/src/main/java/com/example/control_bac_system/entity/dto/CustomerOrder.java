package com.example.control_bac_system.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerOrder {

    // 用户信息
    private String username;
    private Integer gender;
    private String phoneNumber;
    private String email;
    private String province;
    private String city;
    private String district;
    private String detailedAddress;
    private String description;
    // 订单信息
    private String productId;
    private Integer productCount;
    private BigDecimal productAmountTotal;
    private BigDecimal orderAmountTotal;
    private BigDecimal logisticsFee;
    private String desc;
    private Integer status;
    private BigDecimal price;


}

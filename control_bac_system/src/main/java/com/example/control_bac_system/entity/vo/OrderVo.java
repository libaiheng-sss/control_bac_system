package com.example.control_bac_system.entity.vo;

import lombok.Data;

@Data
public class OrderVo {
    private String userId;
    private String orderId;
    private String customerId;
    private String teamId;
    private String customerName;
    private String username;
    private String productName;
    private String price;
    private String productCount;
    private String productAmountTotal;
    private String logisticsFee;
    private String orderAmountTotal;
    private String orderStatus;
    private String desc;
    private String payTime;
    private String sendTime;
    private String orderSettlementTime;
    private String updateTime;
    private String createTime;
}

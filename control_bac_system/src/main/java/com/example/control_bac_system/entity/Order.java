package com.example.control_bac_system.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

@Data
public class Order {
    private Integer id;
    private String customerId;
    private String orderId;
    private String productId;
    private Integer orderStatus;
    private Integer productCount;
    private BigDecimal productAmountTotal;
    private BigDecimal orderAmountTotal;
    private BigDecimal logisticsFee;
    private String payTime;
    private String sendTime;
    private String orderSettlementTime;
    private String updateTime;
    private String createTime;
}

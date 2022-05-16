package com.example.control_bac_system.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private Integer id;
    private Integer parentId;
    private String productName;
    private String productCode;
    private BigDecimal price;
    private String description;
    private String createTime;
    private boolean hasChildren;
    private Integer status;
}

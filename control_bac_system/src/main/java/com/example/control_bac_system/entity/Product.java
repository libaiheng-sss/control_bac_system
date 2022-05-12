package com.example.control_bac_system.entity;

import lombok.Data;

@Data
public class Product {

    private Integer id;
    private String productName;
    private String productCode;
    private String description;
    private String createTime;
}

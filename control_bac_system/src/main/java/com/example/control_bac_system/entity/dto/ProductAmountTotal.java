package com.example.control_bac_system.entity.dto;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;

@Data
public class ProductAmountTotal {

    private BigDecimal price;
    private Integer count;
    private BigDecimal total;
}

package com.example.control_bac_system.entity.vo;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderProductVo {

    private Integer id;
    private Integer parentId;
    private String label; // productName;
    private String value; // productCode;
    private String price;
    private List<OrderProductVo> children;
}

package com.example.control_bac_system.entity;

import lombok.Data;

@Data
public class Districts {
    private Integer id;
    private String name;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private Integer level;
}

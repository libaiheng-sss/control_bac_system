package com.example.control_bac_system.entity;


import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Data
public class PageQuery {

    private Integer page;
    private Integer limit;
    private Integer start;
    private Integer end;
    private String beginTime;
    private String endTime;
    // --------------user_list
    private String phoneNumber;
    private Integer status;
}

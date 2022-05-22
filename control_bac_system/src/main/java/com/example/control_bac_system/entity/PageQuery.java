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
    private Integer id;
    // --------------user_list
    private String phoneNumber;
    private String status;
    // -----------------product
    private boolean hasChildren;
    // ---------------customer
    private Integer userId;
    private Integer teamUserId;
    private String teamId;
    // ----------------order
    private String orderStatus;

}

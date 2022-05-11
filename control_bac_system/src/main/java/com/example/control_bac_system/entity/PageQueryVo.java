package com.example.control_bac_system.entity;

import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Data
public class PageQueryVo<T> {

    // 数据总条数
    private Integer total;
    // 当前页
    private int currentPage;
    // 页面数据
    private List<T> list;


}

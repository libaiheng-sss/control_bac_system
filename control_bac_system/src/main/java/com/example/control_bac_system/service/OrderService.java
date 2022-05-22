package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Order;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;

public interface OrderService {
    int addOrder(Order order);

    PageQueryVo selectAllOrder(PageQuery pageQuery);

    PageQueryVo selectTeamOrder(PageQuery pageQuery);

    PageQueryVo selectPersonalOrder(PageQuery pageQuery);
}

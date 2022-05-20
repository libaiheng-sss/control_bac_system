package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;

public interface CustomerService {
    int addCustomer(Customer customer);

    PageQueryVo selectPersonalCustomer(PageQuery pageQuery);

    PageQueryVo selectTeamCustomer(PageQuery pageQuery);

    PageQueryVo selectAllCustomer(PageQuery pageQuery);
}

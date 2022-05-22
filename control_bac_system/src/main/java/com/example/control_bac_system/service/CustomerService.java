package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.Team;

import java.util.List;

public interface CustomerService {
    int addCustomer(Customer customer);

    PageQueryVo selectPersonalCustomer(PageQuery pageQuery);

    PageQueryVo selectTeamCustomer(PageQuery pageQuery);

    PageQueryVo selectAllCustomer(PageQuery pageQuery);

    Integer updateCustomer(Customer customer);

    List<UserInfo> getTeamUser(Integer userId);

    List<Team> getTeamList();
}

package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int addCustomer(Customer customer) {
        int i = customerMapper.addCustomer(customer);
        return i;
    }
}

package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.vo.CustomerVO;
import com.example.control_bac_system.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int addCustomer(Customer customer) {
        int i = customerMapper.addCustomer(customer);
        return i;
    }

    @Override
    public PageQueryVo selectPersonalCustomer(PageQuery pageQuery) {
        List<CustomerVO> customerVOS = customerMapper.selectPersonalCustomer(pageQuery);
        return null;
    }

    @Override
    public PageQueryVo selectTeamCustomer(PageQuery pageQuery) {
        List<CustomerVO> customerVOS = customerMapper.selectTeamCustomer(pageQuery);
        return null;
    }

    @Override
    public PageQueryVo selectAllCustomer(PageQuery pageQuery) {
        List<CustomerVO> customerVOS = customerMapper.selectAllCustomer(pageQuery);
        return null;
    }
}

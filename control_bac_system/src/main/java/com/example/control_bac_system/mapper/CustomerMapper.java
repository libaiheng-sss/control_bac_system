package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.vo.CustomerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int addCustomer(@Param("customer")Customer customer);
    int deleteCustomer(@Param("customer") Customer customer);
    int updateCustomer(@Param("customer") Customer customer);
    List<CustomerVO> selectCustomerList(@Param("pageQuery") PageQuery pageQuery);

}

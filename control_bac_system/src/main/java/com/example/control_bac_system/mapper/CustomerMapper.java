package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.CustomerVO;
import com.example.control_bac_system.entity.vo.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int addCustomer(@Param("customer")Customer customer);
    int deleteCustomer(@Param("customer") Customer customer);
    int updateCustomer(@Param("customer") Customer customer);
    List<CustomerVO> selectCustomerList(@Param("pageQuery") PageQuery pageQuery);

    List<CustomerVO> selectPersonalCustomer(@Param("pageQuery") PageQuery pageQuery);

    List<CustomerVO> selectTeamCustomer(@Param("pageQuery") PageQuery pageQuery);

    List<CustomerVO> selectAllCustomer(@Param("pageQuery") PageQuery pageQuery);

    Integer selectPersonalCustomerTotal(@Param("pageQuery") PageQuery pageQuery);

    Integer selectAllCustomerTotal(@Param("pageQuery") PageQuery pageQuery);

    Integer selectTeamCustomerTotal(@Param("pageQuery") PageQuery pageQuery);

    List<Integer> selectTeamUserId(@Param("userId") Integer userId);

    List<UserInfo> getTeamUser(@Param("userId") Integer userId);

    List<Team> getTeamList();
}

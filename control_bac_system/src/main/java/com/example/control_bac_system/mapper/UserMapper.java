package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    UserInfo selectUserByUsername(String username);
}

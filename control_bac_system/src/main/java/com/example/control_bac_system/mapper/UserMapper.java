package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {


    UserInfo selectUserByUsername(@Param("username") String username);

    List<String> selectUserRoleByUserId(@Param("userId") Integer userId);
}

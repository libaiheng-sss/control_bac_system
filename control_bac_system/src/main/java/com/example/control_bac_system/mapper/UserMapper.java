package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {


    UserInfo selectUserByUsername(@Param("username") String username);

    List<String> selectUserRoleByUserId(@Param("userId") Integer userId);

    List<UserInfo> selectAllUserInfo();

    int createUser(UserInfo userInfo);

    int updateUser(UserInfo userInfo);

    int deleteUser(Integer userId);

    int updatePassword(UserInfo userInfo);

}

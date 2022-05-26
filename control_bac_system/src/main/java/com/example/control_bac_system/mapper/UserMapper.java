package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {


    UserInfo selectUserByUsername(@Param("username") String username);

    List<String> selectUserRoleByUserId(@Param("userId") Integer userId);

    List<UserInfo> selectAllUserInfo(@Param("pageQuery") PageQuery pageQuery);

    Integer selectUserTotal(@Param("pageQuery") PageQuery pageQuery);

    int createUser(@Param("userInfo") UserInfo userInfo);

    int updateUser(@Param("userInfo") UserInfo userInfo);

    int deleteUser(@Param("userId") Integer userId,@Param("status") Integer status);

    int updatePassword(@Param("userInfo") UserInfo userInfo);

    List<String> selectUrlsByRoles(@Param("roles") List<String> roles);
    List<String> selectAllUrlsByRoles();

    List<UserInfoVo> selectAllUserInfoList();
}

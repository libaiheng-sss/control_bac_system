package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getUserList();

    Integer createUser(UserInfo userInfo);

    Integer updateUser(UserInfo userInfo);

    Integer deleteUser(Integer id,Integer status);
}

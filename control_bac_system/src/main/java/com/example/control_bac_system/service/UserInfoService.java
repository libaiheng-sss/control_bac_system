package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService {

    PageQueryVo getUserList(PageQuery pageQuery);

    Integer createUser(UserInfo userInfo);

    Integer updateUser(UserInfo userInfo);

    Integer deleteUser(Integer id,Integer status);

    List<UserInfoVo> getAllUser();
}

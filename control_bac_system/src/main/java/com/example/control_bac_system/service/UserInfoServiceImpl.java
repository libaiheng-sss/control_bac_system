package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserMapper userMapper;
    @Override
    public List<UserInfo> getUserList() {
        List<UserInfo> userInfos = userMapper.selectAllUserInfo();
        return userInfos;
    }

    @Override
    public Integer createUser(UserInfo userInfo) {
        int userId = userMapper.createUser(userInfo);
        return userId;
    }

    @Override
    public Integer updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        return i;
    }

    @Override
    public Integer deleteUser(Integer id) {
        int i = userMapper.deleteUser(id);
        return i;
    }
}

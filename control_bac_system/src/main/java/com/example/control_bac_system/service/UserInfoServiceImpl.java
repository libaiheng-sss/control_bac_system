package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public List<UserInfo> getUserList() {
        List<UserInfo> userInfos = userMapper.selectAllUserInfo();
        return userInfos;
    }

    @Override
    public Integer createUser(UserInfo userInfo) {
        Long currentTime = System.currentTimeMillis();
        String encode = passwordEncoder.encode(userInfo.getPhoneNumber().substring(5, 11));
        userInfo.setPassword(encode);
        userInfo.setCreateTime(String.valueOf(currentTime));
        userInfo.setUpdateTime(String.valueOf(currentTime));
        int userId = userMapper.createUser(userInfo);
        return userId;
    }

    @Override
    public Integer updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        return i;
    }

    @Override
    public Integer deleteUser(Integer id, Integer status) {
        int i = userMapper.deleteUser(id,status);
        return i;
    }
}

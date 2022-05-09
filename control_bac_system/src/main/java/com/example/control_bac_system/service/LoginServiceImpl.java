package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    private UserMapper userMapper;
    @Override
    public String login(String username, String password) {
        UserInfo user = userMapper.selectUserByUsername("w");
        return user.toString();
    }
}

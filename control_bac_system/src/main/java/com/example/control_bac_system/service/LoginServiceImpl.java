package com.example.control_bac_system.service;

import com.alibaba.fastjson.JSONObject;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.UserInfoVo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    private UserMapper userMapper;
    @Override
    public String getInfo(String username) {
        UserInfo user = userMapper.selectUserByUsername(username);
        List<String> roles = userMapper.selectUserRoleByUserId(user.getId());
        if (username.equals("admin")){
            roles.add("admin");
        }
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUsername(username);
        userInfoVo.setRoles(roles);
        String s = JSONObject.toJSONString(userInfoVo);
        return s;
    }
}

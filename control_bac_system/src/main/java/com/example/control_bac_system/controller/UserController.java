package com.example.control_bac_system.controller;


import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("userList")
    public String getUserList(){
        List<UserInfo> userInfoList = userInfoService.getUserList();
        return null;
    }

    @PostMapping("create")
    public String createUser(UserInfo userInfo){
        Integer i = userInfoService.createUser(userInfo);
        return null;
    }

    @PostMapping("updataUser")
    public String updateUser(UserInfo userInfo){
        Integer i = userInfoService.updateUser(userInfo);
        return null;
    }

    @DeleteMapping("delete")
    public String deleteUser(Integer id){
        Integer i = userInfoService.deleteUser(id);
        return null;
    }
}

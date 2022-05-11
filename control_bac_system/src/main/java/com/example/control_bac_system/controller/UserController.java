package com.example.control_bac_system.controller;


import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.UserInfoService;
import com.example.control_bac_system.tool.Tools;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.tools.Tool;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("userList")
    public String getUserList(){
        List<UserInfo> userInfoList = userInfoService.getUserList();
        String jsonStr = ResultModel.SUCCESS("200", "获取成功", userInfoList);
        return jsonStr;
    }

    @PostMapping("createUser")
    public String createUser(@RequestBody UserInfo userInfo){
        Integer i = userInfoService.createUser(userInfo);
        String jsonStr = ResultModel.SUCCESS("200", "获取成功", i);
        return jsonStr;
    }

    @PostMapping("updataUser")
    public String updateUser(UserInfo userInfo){
        Integer i = userInfoService.updateUser(userInfo);
        return null;
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestParam(value="id") Integer id,@RequestParam(value="status") Integer status){
        Integer i = userInfoService.deleteUser(id,status);
        return null;
    }
}

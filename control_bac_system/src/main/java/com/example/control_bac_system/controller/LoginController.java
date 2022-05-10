package com.example.control_bac_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.LoginService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("info")
    public String info(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            String userInfo = loginService.getInfo(currentUserName);
            String result = ResultModel.SUCCESS("200", "获取用户信息成功！", JSONObject.parseObject(userInfo));
            return result;
        }else{
            throw new UsernameNotFoundException("用户名不存在！");
        }
    }


    @GetMapping("/cms/login")
    public String printStr(){

        return "asdfasdfsdfadsfasdfasdfds";
    }
}

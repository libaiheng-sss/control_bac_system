package com.example.control_bac_system.controller;

import com.example.control_bac_system.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("login")
    public String login(String username,String password){
        String result = loginService.login(username, password);
        return result;
    }

    @GetMapping("/cms/login")
    public String printStr(){

        return "asdfasdfsdfadsfasdfasdfds";
    }
}

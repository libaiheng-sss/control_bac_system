package com.example.control_bac_system.controller;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("personal")
    public String getPersonalCustomer(@RequestBody PageQuery pageQuery){
        PageQueryVo pageQueryVo = customerService.selectPersonalCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取个人客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("team")
    public String getTeamCustomer(@RequestBody PageQuery pageQuery){
        PageQueryVo pageQueryVo = customerService.selectTeamCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("all")
    public String getAllCustomer(@RequestBody PageQuery pageQuery){
        PageQueryVo pageQueryVo = customerService.selectAllCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }
}

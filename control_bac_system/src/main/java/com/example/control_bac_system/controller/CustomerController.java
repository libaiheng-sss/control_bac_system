package com.example.control_bac_system.controller;

import com.example.control_bac_system.aoth.entity.User;
import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.Team;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.CustomerService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("personal")
    public String getPersonalCustomer(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = customerService.selectPersonalCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取个人客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("team")
    public String getTeamCustomer(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = customerService.selectTeamCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("all")
    public String getAllCustomer(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = customerService.selectAllCustomer(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }
    @RequestMapping("addCustomer")
    public String addCustomer(@RequestBody Customer customer){
        if (null != customer.getCustomerId() && !customer.getCustomerId().isEmpty()){
            String currentTime = String.valueOf(System.currentTimeMillis());
            customer.setUpdateTime(currentTime);
            Integer integer = customerService.updateCustomer(customer);
            String success = ResultModel.SUCCESS("200", "修改客户成功", integer);
            return success;
        }else {
            String customerId = UUID.randomUUID().toString().replaceAll("-","");
            String currentTime = String.valueOf(System.currentTimeMillis());
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!(authentication instanceof AnonymousAuthenticationToken)) {
                User principal = (User) authentication.getPrincipal();
                customer.setUserId(principal.getId());
            }
            customer.setCustomerId(customerId);
            customer.setUpdateTime(currentTime);
            customer.setCreateTime(currentTime);
            Integer i = customerService.addCustomer(customer);
            String success = ResultModel.SUCCESS("200", "添加客户成功", i);
            return success;
        }
    }

    @RequestMapping("updateCustomer")
    public String updateCustomer(@RequestBody Customer customer){
        Integer i = customerService.updateCustomer(customer);
        String success = ResultModel.SUCCESS("200", "更新客户成功", i);
        return success;
    }


    @RequestMapping("getTeamUser")
    public String getTeamUser(){
        Integer userId = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            userId = principal.getId();
        }
        List<UserInfo> users = customerService.getTeamUser(userId);
        String success = ResultModel.SUCCESS("200", "获取团队用户列表", users);
        return success;
    }

    @RequestMapping("getTeamList")
    public String getTeamList(){
        List<Team> teams = customerService.getTeamList();
        String success = ResultModel.SUCCESS("200", "获取团队列表成功！", teams);
        return success;
    }
}

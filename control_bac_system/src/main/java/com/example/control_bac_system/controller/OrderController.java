package com.example.control_bac_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.control_bac_system.aoth.entity.User;
import com.example.control_bac_system.entity.*;
import com.example.control_bac_system.entity.dto.CustomerOrder;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.CustomerService;
import com.example.control_bac_system.service.OrderService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private CustomerService customerService;
    @Resource
    private OrderService orderService;

    @RequestMapping("addOrderAndCustomer")
    public String addOrderAndCustomer(@RequestBody CustomerOrder customerOrder){
        String customerId = UUID.randomUUID().toString().replaceAll("-","");
        String orderId = UUID.randomUUID().toString().replaceAll("-","");
        Integer userId = null;
        String currentTime = String.valueOf(System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            userId = principal.getId();
        }
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setUsername(customerOrder.getUsername());
        customer.setPhoneNumber(customerOrder.getPhoneNumber());
        customer.setEmail(customerOrder.getEmail());
        customer.setProvince(customerOrder.getProvince());
        customer.setCity(customerOrder.getCity());
        customer.setDistrict(customerOrder.getDistrict());
        customer.setDetailedAddress(customerOrder.getDetailedAddress());
        customer.setUserId(userId);
        customer.setDescription(customerOrder.getDescription());
        customer.setCreateTime(currentTime);
        customer.setUpdateTime(currentTime);
        int a = customerService.addCustomer(customer);
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId(orderId);
        order.setProductId(customerOrder.getProductId());
        if (null == customerOrder.getStatus()){
            order.setOrderStatus(0);
        }else {
            order.setOrderStatus(customerOrder.getStatus());
        }
        order.setProductCount(customerOrder.getProductCount());
        order.setProductAmountTotal(customerOrder.getPrice().multiply(BigDecimal.valueOf(customerOrder.getProductCount())));
        order.setOrderAmountTotal(customerOrder.getOrderAmountTotal());
        order.setLogisticsFee(customerOrder.getLogisticsFee());
        order.setUserId(userId);
        if (null != customerOrder.getStatus() && customerOrder.getStatus() == 2){
            order.setPayTime(currentTime);
        }
        order.setUpdateTime(currentTime);
        order.setCreateTime(currentTime);
        int b = orderService.addOrder(order);
        return null;
    }

    @RequestMapping("addOrder")
    public String addOrder(@RequestBody Order order){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            order.setUserId(principal.getId());
        }
        String orderId = UUID.randomUUID().toString().replaceAll("-","");
        String currentTime = String.valueOf(System.currentTimeMillis());
        order.setOrderId(orderId);
        order.setUpdateTime(currentTime);
        order.setCreateTime(currentTime);
        order.setOrderStatus(0);
        if (null == order.getPrice()){
            order.setPrice(new BigDecimal(0));
        }
        if (null == order.getCustomerId() || !order.getCustomerId().isEmpty()){
            String success = ResultModel.SUCCESS("300", "添加订单失败", null);
        }
        order.setProductAmountTotal(order.getPrice().multiply(BigDecimal.valueOf(order.getProductCount())));
       Integer i = orderService.addOrder(order);
        String success = ResultModel.SUCCESS("200", "添加订单成功", i);
        return success;
    }

    @RequestMapping("personal")
    public String getPersonalOrder(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = orderService.selectPersonalOrder(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取个人客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("team")
    public String getTeamOrder(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = orderService.selectTeamOrder(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }

    @RequestMapping("all")
    public String getAllOrder(@RequestBody PageQuery pageQuery){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User principal = (User) authentication.getPrincipal();
            pageQuery.setUserId(principal.getId());
        }
        PageQueryVo pageQueryVo = orderService.selectAllOrder(pageQuery);
        String success = ResultModel.SUCCESS("200", "获取团队客户列表成功", pageQueryVo);
        return success;
    }
}

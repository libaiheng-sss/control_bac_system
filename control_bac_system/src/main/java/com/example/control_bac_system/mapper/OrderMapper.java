package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.Order;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 添加订单
    int addOrder(@Param("order") Order order);
    // 修改订单
    int updateOrder(@Param("order") Order order);
    // 删除订单
    int deleteOrder(@Param("order") Order order);
    // 查询订单
    List<OrderVo> selectOrderList(@Param("pageQuery") PageQuery pageQuery);

}

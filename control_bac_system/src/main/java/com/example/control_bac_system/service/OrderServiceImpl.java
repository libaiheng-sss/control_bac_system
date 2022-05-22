package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Order;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.vo.CustomerVO;
import com.example.control_bac_system.entity.vo.OrderVo;
import com.example.control_bac_system.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public int addOrder(Order order) {
        int i = orderMapper.addOrder(order);
        return i;
    }

    @Override
    public PageQueryVo selectAllOrder(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = orderMapper.selectAllOrderTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<OrderVo> customerVOS = orderMapper.selectAllOrder(pageQuery);
        PageQueryVo<OrderVo> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }

    @Override
    public PageQueryVo selectTeamOrder(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = orderMapper.selectTeamOrderTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<OrderVo> customerVOS = orderMapper.selectTeamOrder(pageQuery);
        PageQueryVo<OrderVo> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }

    @Override
    public PageQueryVo selectPersonalOrder(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = orderMapper.selectPersonalOrderTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<OrderVo> customerVOS = orderMapper.selectPersonalOrder(pageQuery);
        PageQueryVo<OrderVo> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }
}

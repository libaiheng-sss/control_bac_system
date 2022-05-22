package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.Customer;
import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.entity.vo.CustomerVO;
import com.example.control_bac_system.entity.vo.Team;
import com.example.control_bac_system.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int addCustomer(Customer customer) {
        int i = customerMapper.addCustomer(customer);
        return i;
    }

    @Override
    public PageQueryVo selectPersonalCustomer(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = customerMapper.selectPersonalCustomerTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<CustomerVO> customerVOS = customerMapper.selectPersonalCustomer(pageQuery);
        PageQueryVo<CustomerVO> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }

    @Override
    public PageQueryVo selectTeamCustomer(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = customerMapper.selectTeamCustomerTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<CustomerVO> customerVOS = customerMapper.selectTeamCustomer(pageQuery);
        PageQueryVo<CustomerVO> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }

    @Override
    public PageQueryVo selectAllCustomer(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = customerMapper.selectAllCustomerTotal(pageQuery);

        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<CustomerVO> customerVOS = customerMapper.selectAllCustomer(pageQuery);
        PageQueryVo<CustomerVO> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(customerVOS);
        pageQueryVo.setCurrentPage(currentPage);
        return pageQueryVo;
    }

    @Override
    public Integer updateCustomer(Customer customer) {
        int i = customerMapper.updateCustomer(customer);
        return i;
    }

    @Override
    public List<UserInfo> getTeamUser(Integer userId) {
        List<UserInfo> users = customerMapper.getTeamUser(userId);
        return users;
    }

    @Override
    public List<Team> getTeamList() {
        List<Team> teamList = customerMapper.getTeamList();
        return teamList;
    }
}

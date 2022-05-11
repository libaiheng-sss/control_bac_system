package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public PageQueryVo getUserList(PageQuery pageQuery) {

        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = userMapper.selectUserTotal(pageQuery);
        if (start >= total){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<UserInfo> userInfos = userMapper.selectAllUserInfo(pageQuery);
        PageQueryVo<UserInfo> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(userInfos);
        pageQueryVo.setCurrentPage(currentPage);

        return pageQueryVo;
    }

    @Override
    public Integer createUser(UserInfo userInfo) {
        Long currentTime = System.currentTimeMillis();
        String encode = passwordEncoder.encode(userInfo.getPhoneNumber().substring(5, 11));
        userInfo.setPassword(encode);
        userInfo.setCreateTime(String.valueOf(currentTime));
        userInfo.setUpdateTime(String.valueOf(currentTime));
        int userId = userMapper.createUser(userInfo);
        return userId;
    }

    @Override
    public Integer updateUser(UserInfo userInfo) {
        int i = userMapper.updateUser(userInfo);
        return i;
    }

    @Override
    public Integer deleteUser(Integer id, Integer status) {
        int i = userMapper.deleteUser(id,status);
        return i;
    }
}

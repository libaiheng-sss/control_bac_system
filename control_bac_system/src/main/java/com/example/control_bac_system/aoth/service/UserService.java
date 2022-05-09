package com.example.control_bac_system.aoth.service;

import cn.hutool.core.util.StrUtil;
import com.example.control_bac_system.aoth.entity.User;
import com.example.control_bac_system.entity.UserInfo;
import com.example.control_bac_system.mapper.UserMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {


    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!StrUtil.isNotBlank(username)){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        UserInfo userInfo = userMapper.selectUserByUsername(username);
        if (null == userInfo){
            throw new UsernameNotFoundException("用户名不存在！");
        }

        User user = new User("admin",passwordEncoder.encode("admin"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
        return user ;
    }

}

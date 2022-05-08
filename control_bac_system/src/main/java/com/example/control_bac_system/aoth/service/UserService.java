package com.example.control_bac_system.aoth.service;

import com.example.control_bac_system.aoth.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // todo 查询数据库
        User user = new User("admin",passwordEncoder.encode("123"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
        return user ;
    }
}

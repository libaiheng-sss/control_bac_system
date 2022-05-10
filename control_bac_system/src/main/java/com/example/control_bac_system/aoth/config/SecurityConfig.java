package com.example.control_bac_system.aoth.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.control_bac_system.aoth.entity.User;
import com.example.control_bac_system.aoth.filter.JwtTokenFilter;
import com.example.control_bac_system.aoth.handler.MyLogOutSuccessHandler;
import com.example.control_bac_system.aoth.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.util.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Resource
    private UserService userService;

    @Resource
    private JwtTokenFilter jwtTokenFilter;

    @Resource
    private MyLogOutSuccessHandler myLogOutSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 设置用户来源，登录的时候就是根据这里查找数据库里面的用户
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtTokenFilter, LogoutFilter.class);
        // 禁用session
        http.sessionManagement().disable();
        http.csrf().disable();
        http.formLogin()
                // 登录成功处理器
                .successHandler(authenticationSuccessHandler())
                // 登录失败处理器
                .failureHandler(authenticationFailureHandler());
        // 除了登录可以匿名访问
        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .anyRequest().authenticated();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(myLogOutSuccessHandler)
                .deleteCookies("JSESSIONID");
    }

    /**
     * 登录成功处理器
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return ((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            User user = (User)authentication.getPrincipal();
            // 用户名
            String username = user.getUsername();
            // 密码
            String password = user.getPassword();
            // 权限
            Collection<GrantedAuthority> grantedAuthorities = (Collection<GrantedAuthority>) user.getAuthorities();
            List<String> roleList = new ArrayList<>();
            grantedAuthorities.forEach(grantedAuthority -> {
                roleList.add(grantedAuthority.getAuthority());
            });
            String[] roles = new String[roleList.size()];
            // 用jwt生成token
            HashMap<String, Object> headMap = new HashMap<>(16);
            // 使用的算法
            headMap.put("alg", "HS256");
            headMap.put("typ", "JWT");
            Date nowDate = new Date();
            // 过期时间可以自定义
            Date expDate = new Date(nowDate.getTime() + 2 * 60 * 60 * 1000);
            String jwt = JWT.create().withHeader(headMap)
                    .withIssuedAt(nowDate)
                    .withExpiresAt(expDate)
                    // 主题，自定义
                    .withSubject("demo")
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withArrayClaim("role", roleList.toArray(roles))
                    // 签名，自定义，同一个项目中签名是唯一
                    .sign(Algorithm.HMAC256("test"));
            // 保存token到redis
//            redisTemplate.opsForValue().set("token:" + jwt, user, 7200);
            // todo 保存到数据库
            System.out.println("token:" + jwt+":"+user+",ex:"+7200);

            // 返回token
            HashMap<String, Object> hashMap = new HashMap<>(16);
            hashMap.put("username", username);
            hashMap.put("create_time", nowDate);
            hashMap.put("expires_time", expDate);
            hashMap.put("access_token", jwt);
            hashMap.put("type", "bearer");
            hashMap.put("code", "2000");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(hashMap);
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.write(s);
            printWriter.flush();
            printWriter.close();
        });
    }

    /**
     * 登录失败处理器
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return ((httpServletRequest, httpServletResponse, e) -> {
            HashMap<String, Object> hashMap = new HashMap<>(16);
            hashMap.put("error", e);
            hashMap.put("message", "登录失败");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(hashMap);
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.write(s);
            printWriter.flush();
            printWriter.close();
        });
    }
}

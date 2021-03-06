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
     * ????????????????????????????????????????????????????????????????????????????????????
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtTokenFilter, LogoutFilter.class);
        // ??????session
        http.sessionManagement().disable();
        http.csrf().disable();
        http.formLogin()
                // ?????????????????????
                .successHandler(authenticationSuccessHandler())
                // ?????????????????????
                .failureHandler(authenticationFailureHandler());
        // ??????????????????????????????
        http.authorizeRequests()
                .antMatchers("/login").anonymous()
                .anyRequest().authenticated();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(myLogOutSuccessHandler)
                .deleteCookies("JSESSIONID");
    }

    /**
     * ?????????????????????
     */
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return ((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=utf-8");
            User user = (User)authentication.getPrincipal();
            // ??????id
            Integer id = user.getId();
            // ?????????
            String username = user.getUsername();
            // ??????
            String password = user.getPassword();
            // ??????
            Collection<GrantedAuthority> grantedAuthorities = (Collection<GrantedAuthority>) user.getAuthorities();
            List<String> roleList = new ArrayList<>();
            grantedAuthorities.forEach(grantedAuthority -> {
                roleList.add(grantedAuthority.getAuthority());
            });
            String[] roles = new String[roleList.size()];
            // ???jwt??????token
            HashMap<String, Object> headMap = new HashMap<>(16);
            // ???????????????
            headMap.put("alg", "HS256");
            headMap.put("typ", "JWT");
            Date nowDate = new Date();
            // ???????????????????????????
            Date expDate = new Date(nowDate.getTime() + 2 * 60 * 60 * 1000);
            String jwt = JWT.create().withHeader(headMap)
                    .withIssuedAt(nowDate)
                    .withExpiresAt(expDate)
                    // ??????????????????
                    .withSubject("demo")
                    .withClaim("id", id)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withArrayClaim("role", roleList.toArray(roles))
                    // ??????????????????????????????????????????????????????
                    .sign(Algorithm.HMAC256("test"));
            // ??????token???redis
//            redisTemplate.opsForValue().set("token:" + jwt, user, 7200);
            // todo ??????????????????
            System.out.println("token:" + jwt+":"+user+",ex:"+7200);

            // ??????token
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
     * ?????????????????????
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return ((httpServletRequest, httpServletResponse, e) -> {
            HashMap<String, Object> hashMap = new HashMap<>(16);
            hashMap.put("error", e);
            hashMap.put("message", "????????????");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(hashMap);
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.write(s);
            printWriter.flush();
            printWriter.close();
        });
    }
}

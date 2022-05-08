package com.example.control_bac_system.aoth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/favicon.ico", "/signIn", "/signUp", "/security_check", "/404", "/captcha/**", "/user/me", "/oauth/check_token", "/oauth/token", "/.well-known/**").permitAll()
                .mvcMatchers("/oauth/signUp").permitAll()
                .mvcMatchers("/management/**").hasAnyAuthority("超级")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signIn?out")
                .and()
                .formLogin();

    }
}

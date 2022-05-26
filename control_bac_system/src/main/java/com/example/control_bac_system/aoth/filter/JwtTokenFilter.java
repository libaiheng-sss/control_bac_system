package com.example.control_bac_system.aoth.filter;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.control_bac_system.aoth.entity.User;
import com.example.control_bac_system.mapper.UserMapper;
import com.example.control_bac_system.model.ResultModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class JwtTokenFilter extends OncePerRequestFilter {

    @Resource
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String path = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        // 对于登录直接放行
        if ("/dev-api/login".equals(path) && "POST".equals(method)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        // 获取token并验证
        String authorization = httpServletRequest.getHeader("Authorization");
        if (!StrUtil.hasBlank(authorization)) {
            String jwtB = authorization.replaceAll("bearer ", "");
            String jwt = jwtB.replaceAll("Bearer ", "");
            // 创建一个token解析器（test作为jwt生成token的签名是自定义的，一般是作为配置固定值）
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("test")).build();
            DecodedJWT decodedJwt;
            try {
                decodedJwt = jwtVerifier.verify(jwt);
            } catch (Exception e) {
                e.printStackTrace();
                returnResponse(httpServletResponse,ResultModel.loginError("1200","token 认证失败~"));
                return;
            }
            // 获取用户名，密码，角色权限
            Integer id = decodedJwt.getClaim("id").asInt();
            String username = decodedJwt.getClaim("username").asString();
            String password = decodedJwt.getClaim("password").asString();
            List<String> roles = decodedJwt.getClaim("role").asList(String.class);
            if (!username.equals("admin")){
                if ( !path.equals("/dev-api/info") && !path.equals("/dev-api/logout")){
                    List<String> urlList = userMapper.selectUrlsByRoles(roles);
                    List<String> allUserList = userMapper.selectAllUrlsByRoles();
                    boolean b = checkUrl(path.replace("/dev-api",""), urlList,allUserList);
                    if (!b){
                        returnResponse(httpServletResponse,ResultModel.Error("没有权限~"));
                        return;
                    }
                }
            }

            List<SimpleGrantedAuthority> roleList = new ArrayList<>();
            roles.forEach(role -> {
                roleList.add(new SimpleGrantedAuthority(role));
            });
            User user = new User(id,username,password, AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(roles.toArray())));
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, roleList);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        returnResponse(httpServletResponse,ResultModel.loginError("1200","token 认证失败~"));
    }

    public void returnResponse(HttpServletResponse httpServletResponse,String txt) throws IOException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.write(txt);
        printWriter.flush();
        printWriter.close();
    }

    private boolean checkUrl(String url, List<String> urlList, List<String> allUrlList) {
        if (allUrlList.contains(url)){
            if (urlList.contains(url)){
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }
}

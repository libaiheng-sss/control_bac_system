package com.example.control_bac_system.aoth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Bean
//    public ClientDetailsService jdbcClientDetailsService(){
//        return new JdbcClientDetailsService(dataSource);
//    }
    /**
     * jwt token转换器
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 签名
        jwtAccessTokenConverter.setSigningKey("test");
        return jwtAccessTokenConverter;
    }
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("CY_Control_back_system")
                .scopes(new BCryptPasswordEncoder().encode("CY_Control_ps_1qa2ws@"))
                .scopes("all")
                .authorizedGrantTypes("password")
                .accessTokenValiditySeconds(7200)
                .redirectUris("https://www.baidu.com");
//        clients.withClientDetails(jdbcClientDetailsService());
    }

//    @Bean
//    public ApprovalStore approvalStore(){
//        return new JdbcApprovalStore(dataSource);
//    }
//
//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices(){
//        return new JdbcAuthorizationCodeServices(dataSource);
//    }

//    // 令牌管理
//    @Bean
//    public AuthorizationServerTokenServices tokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        // token 保存策略
//        tokenServices.setTokenStore(tokenStore());
//        // 支持刷新模式
//        tokenServices.setSupportRefreshToken(true);
//        // 客户端信息来源
//        tokenServices.setClientDetailsService(jdbcClientDetailsService());
//        // token 有效期自定义设置，默认 12 小时
//        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 12);
//        // refresh token 有效期自定义设置，默认 30 天
//        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
//
//        return tokenServices;
//    }

    // 检查 token 的策略，即配置令牌端点的安全约束
    // 就是这个端点谁能访问，谁不能访问
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) {
//        // 此时指 endpoint 完全公开
//        security.tokenKeyAccess("permitAll()");
//        // checkToken 这个 endpoint 完全公开
//        security.checkTokenAccess("permitAll()");
//        // 允许表单认证,这个如果配置支持allowFormAuthenticationForClients的，且url中有client_id和client_secret的会走ClientCredentialsTokenEndpointFilter来保护
//        // 如果没有支持allowFormAuthenticationForClients或者有支持但是url中没有client_id和client_secret的，走basic认证保护
//        security.allowFormAuthenticationForClients();
//
//    }

    // OAuth2 的主配置信息
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager);
//                .approvalStore(approvalStore())
//                .authenticationManager(authenticationManager)
//                .authorizationCodeServices(authorizationCodeServices())
//                .tokenServices(tokenServices());
    }


}

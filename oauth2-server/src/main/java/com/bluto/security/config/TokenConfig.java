package com.bluto.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * TokenConfig
 *
 * @author bluto
 * @Description: 令牌相关配置
 * @date 2020/6/7 9:51
 */
@Configuration
public class TokenConfig {

    @Autowired
    private ClientDetailsService clientDetailsService;

    //令牌存储策略
    @Bean
    public TokenStore tokenStore(){
        //内存方式
        return new InMemoryTokenStore();
    }

    //授权令牌服务
    @Bean
    @Autowired
    public AuthorizationServerTokenServices tokenServices(TokenStore tokenStore){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        services.setAccessTokenValiditySeconds(2 * 3600);
        services.setRefreshTokenValiditySeconds(3 * 24 * 3600);
        return services;
    }
}

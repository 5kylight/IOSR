package com.wiet.math.core.dividers.communication.auth;

import feign.Feign;
import feign.RequestInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

@Configuration
@ConditionalOnClass({ Feign.class })
@ConditionalOnProperty(value = "feign.oauth2.enabled", matchIfMissing = true)
public class OAuth2FeignAutoConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(OAuth2FeignAutoConfiguration.class);

    @Bean
    @ConditionalOnBean(OAuth2ClientContext.class)
    public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext) {
        LOGGER.warn(String.format("OAuth2 Feign Request Interceptor initialized. " +
                "Client context is %s.", oauth2ClientContext == null ? "null" : "autowired"));
        return new OAuth2FeignRequestInterceptor(oauth2ClientContext);
    }
}

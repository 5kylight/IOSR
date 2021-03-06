package com.wiet.math.core.dividers;

import com.wiet.math.core.dividers.communication.DividersServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = DividersServiceClient.class)
@EnableResourceServer
@EnableOAuth2Client
public class DividersProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DividersProductServiceApplication.class, args);
    }
}

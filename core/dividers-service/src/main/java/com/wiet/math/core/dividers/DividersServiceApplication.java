package com.wiet.math.core.dividers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
public class DividersServiceApplication  extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(DividersServiceApplication.class, args);
	}
}

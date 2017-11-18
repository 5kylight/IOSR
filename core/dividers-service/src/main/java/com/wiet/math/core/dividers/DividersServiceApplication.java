package com.wiet.math.core.dividers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DividersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DividersServiceApplication.class, args);
	}
}

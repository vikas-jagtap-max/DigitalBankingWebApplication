package com.infymeMobile.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class InfyMeMobileUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyMeMobileUserApplication.class, args);
		System.out.println("User microservice has started...");
	}

}

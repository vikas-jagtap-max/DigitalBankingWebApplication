package com.infymeMobile.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableConfigClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class InfyMeMobileAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyMeMobileAccountApplication.class, args);
		System.out.println("Account microservice has started...");
	}

}

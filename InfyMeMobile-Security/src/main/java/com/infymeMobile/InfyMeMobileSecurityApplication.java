package com.infymeMobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InfyMeMobileSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyMeMobileSecurityApplication.class, args);
		System.out.println("Security microservice has started...");
	}

}

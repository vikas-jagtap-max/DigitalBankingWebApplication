package com.infymeMobile.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InfyMeMobileApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(InfyMeMobileApiGatewayApplication.class, args);
		System.out.println("API Gateway has started...");
	}

}
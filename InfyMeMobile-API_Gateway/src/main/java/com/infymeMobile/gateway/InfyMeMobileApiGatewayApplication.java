package com.infymeMobile.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.infymeMobile.security") //
public class InfyMeMobileApiGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(InfyMeMobileApiGatewayApplication.class, args);
		System.out.println("API Gateway has started...");
	}

}

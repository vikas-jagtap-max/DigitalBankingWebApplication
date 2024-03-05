package com.infymeMobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class InfyMeMobileServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyMeMobileServiceRegistryApplication.class, args);
		System.out.println("Service registry has started...");
	}

}

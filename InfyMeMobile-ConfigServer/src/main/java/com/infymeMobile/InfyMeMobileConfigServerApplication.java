package com.infymeMobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//
@EnableConfigServer
@SpringBootApplication
public class InfyMeMobileConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyMeMobileConfigServerApplication.class, args);
		System.out.println("Spring cloud config server is started...");
	}

}

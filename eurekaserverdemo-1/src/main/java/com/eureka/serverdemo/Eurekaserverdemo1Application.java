package com.eureka.serverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserverdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaserverdemo1Application.class, args);
	}

}

package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class Demo1DiscoverserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1DiscoverserviceApplication.class, args);
	}

}

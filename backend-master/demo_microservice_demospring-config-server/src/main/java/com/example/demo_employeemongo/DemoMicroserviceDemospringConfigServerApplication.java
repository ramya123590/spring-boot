package com.example.demo_employeemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoMicroserviceDemospringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroserviceDemospringConfigServerApplication.class, args);
	}

}

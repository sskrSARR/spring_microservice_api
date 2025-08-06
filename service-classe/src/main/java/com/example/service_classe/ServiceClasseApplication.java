package com.example.service_classe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceClasseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClasseApplication.class, args);
	}

}

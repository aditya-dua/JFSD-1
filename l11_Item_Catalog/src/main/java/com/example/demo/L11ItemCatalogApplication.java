package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class L11ItemCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(L11ItemCatalogApplication.class, args);
	}
	
	
	@GetMapping()
	public String test() {
		return "Test API works!";
	}
	

}

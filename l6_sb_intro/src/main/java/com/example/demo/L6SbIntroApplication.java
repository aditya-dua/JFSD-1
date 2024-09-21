package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class L6SbIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(L6SbIntroApplication.class, args);
	}
	
	@GetMapping()
	public String hello() {
		
		return "Hello World!";
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class L11SpringSecurityOAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(L11SpringSecurityOAuthApplication.class, args);
	}

}

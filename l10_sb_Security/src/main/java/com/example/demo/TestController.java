package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping
	public String test() {
		return "Test API works!";
	}
	@GetMapping("/home")
	public String home() {
		return "Home API works!";
	}
	@GetMapping("/admin")
	public String admin() {
		return "Admin API works!";
	}
	@GetMapping("/user")
	public String user() {
		return "User API works!";
	}
}

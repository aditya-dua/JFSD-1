package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/test/message")
	public String test() {
		return "Test API works!!";
	}
	@GetMapping("/test/text")
	public Message text() {
		Message m = new Message();
		m.text="My Text";
		return m;
	}
	//https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
}

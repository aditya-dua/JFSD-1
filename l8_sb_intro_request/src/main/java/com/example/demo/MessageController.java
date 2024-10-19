package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/test/message")
	public String test() {
		return "Test API works!!";
	}
	
	@RequestMapping("/greet")
	public Message greeting(@RequestParam String name) {
		
		Message m = new Message();
		m.setText("Hello "+name);
		
		return m;
		
	}
	
	@RequestMapping("/greet/{name}")
	public Message greetingPath(@PathVariable String name) {
		
		Message m = new Message();
		m.setText("Hello "+name);
		
		return m;
		
	}
	
	@PostMapping("/greet/create")
	public Message createMessage(@RequestBody Message msg) {
		
		System.out.println(msg);
		
		return msg;
		
	}
	//https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
}

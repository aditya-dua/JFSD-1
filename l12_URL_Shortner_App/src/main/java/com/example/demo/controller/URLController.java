package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UrlRequest;
import com.example.demo.entity.URL;
import com.example.demo.service.URLService;

@RestController
@RequestMapping("/api/v1/url")
public class URLController {

	@Autowired
	private URLService urlService;
	
	@GetMapping("/test")
	public String test() {
		return "Test API works!";
	}
	
	@PostMapping("/shorten")
	public String shortenUrl(@RequestBody UrlRequest request) {
		return urlService.shortenUrl(request.getOriginalUrl(), request.getUserId());
	}
	@GetMapping("/{shortUrl}")
	public String getOriginalUrl(@PathVariable String shortUrl) {
		return urlService.getOriginalUrl(shortUrl);
	}
	
	@GetMapping("/stats/{shortUrl}")
	public URL getUrl(@PathVariable String shortUrl) {
		return urlService.getUrl(shortUrl);
	}
	
	@GetMapping("/list")
	public List<URL> getAllUrls() {
		return urlService.getAllShortenedUrl();
	}
}

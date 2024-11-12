package com.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.URL;
import com.example.demo.repo.UrlRepository;

@Service
public class URLService {

	@Autowired
	private UrlRepository urlRepository;
	
	 private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 private static final int BASE = 62;

	public String shortenUrl(String originalUrl,String userId) {
		Optional<URL> existingURL = urlRepository.findByOriginalUrl(originalUrl);
		
		if(existingURL.isPresent()) {
			return existingURL.get().getShortUrl();
		}
		
		URL url = new URL();
        url.setOriginalUrl(originalUrl);
        url.setCount(0);
        
        url.setUserId(userId);
        
        urlRepository.save(url);
        String shortUrl = encodeId(url.getId());
        url.setShortUrl(shortUrl);
        urlRepository.save(url);
        
        
        //String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes(StandardCharsets.UTF_8)).substring(0, 8);
        
        return shortUrl;
	}
	
	public String getOriginalUrl(String shortUrl) {
		URL url = urlRepository.findByShortUrl(shortUrl)
				.orElseThrow(()-> new RuntimeException("URL not found"));
		
		url.setCount(url.getCount()+1);
		urlRepository.save(url);
		
		return url.getOriginalUrl();
	}
	
	public URL getUrl(String shortUrl) {
		URL url = urlRepository.findByShortUrl(shortUrl)
				.orElseThrow(()-> new RuntimeException("URL not found"));
		return url;
	}
	public List<URL> getAllShortenedUrl() {
		return urlRepository.findAll();
	}
	
	
	// Method to encode a database ID to a short URL
    private String encodeId(Long id) {
        StringBuilder encoded = new StringBuilder();
        while (id > 0) {
            encoded.append(BASE62.charAt((int) (id % BASE)));
            id /= BASE;
        }
        return encoded.reverse().toString();
    }
}

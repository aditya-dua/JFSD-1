package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.URL;

public interface UrlRepository extends JpaRepository<URL, Long>{

	Optional<URL> findByShortUrl(String shortUrl);
	Optional<URL> findByOriginalUrl(String originalUrl);
	
}

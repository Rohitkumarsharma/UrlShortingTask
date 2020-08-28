package com.urlshortener.service;

import org.springframework.http.ResponseEntity;

public interface UrlShortenerService {
	
	public ResponseEntity<String> shortenUrl(String url);

}

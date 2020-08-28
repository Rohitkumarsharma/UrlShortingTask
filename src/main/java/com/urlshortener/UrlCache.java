package com.urlshortener;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class UrlCache {
	
	
	private ConcurrentHashMap<String, String> urlCache;
	
	public UrlCache()
	{
		urlCache = new ConcurrentHashMap<>();
	}

	public ConcurrentHashMap<String, String> getUrlCache() 
	{
		return urlCache;
	}

	public void setUrlCache(ConcurrentHashMap<String, String> urlCache) {
		this.urlCache = urlCache;
	}
	
	

}

package com.urlshortener;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class UrlCache {
	
	
	private ConcurrentHashMap<String, String> urlCache;
	private ConcurrentHashMap<String, String> longUrlToShortUrlChache;
	
	public UrlCache()
	{
		urlCache = new ConcurrentHashMap<>();
		longUrlToShortUrlChache = new ConcurrentHashMap<>();
	}

	public ConcurrentHashMap<String, String> getUrlCache() 
	{
		return urlCache;
	}

	public void setUrlCache(ConcurrentHashMap<String, String> urlCache) {
		this.urlCache = urlCache;
	}

	public ConcurrentHashMap<String, String> getLongUrlToShortUrlChache() {
		return longUrlToShortUrlChache;
	}

	public void setLongUrlToShortUrlChache(ConcurrentHashMap<String, String> longUrlToShortUrlChache) {
		this.longUrlToShortUrlChache = longUrlToShortUrlChache;
	}
}

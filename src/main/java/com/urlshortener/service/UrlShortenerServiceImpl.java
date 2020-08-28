package com.urlshortener.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.urlshortener.UrlCache;
import com.urlshortener.model.Url;
import com.urlshortener.repository.UrlRepositoryService;
import com.urlshortener.util.RamdomUniqueGenratorUtil;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService{

	
	private static final Logger logger = LoggerFactory.getLogger(UrlShortenerServiceImpl.class);
	
	@Value("${baseUrl.baseurl}")
	private String baseUrl ;
	
	@Autowired
    private UrlCache urlCache;
	
	@Autowired
	private UrlRepositoryService urlRepositoryService;
	
	
	@Override
	public ResponseEntity<String> shortenUrl(String url) 
	{
		
		int randomNumber = RamdomUniqueGenratorUtil.getRandomNumberString();
		String convertUniqueString = RamdomUniqueGenratorUtil.convertBase10ToBase62ID(randomNumber);
		String tinyUrl =  baseUrl+convertUniqueString;
		logger.info("In UrlShortenerServiceImpl.shortenUrl() - UniqueId- ",convertUniqueString);
		logger.info("In UrlShortenerServiceImpl.shortenUrl() - tinyUrl- ",tinyUrl);
		saveToDB( convertUniqueString , url);
		updateToCache(convertUniqueString , url);
	
		return ResponseEntity.ok().body(tinyUrl);
	}

	private void updateToCache(String convertUniqueString, String url)
	{		
		
		logger.info("In UrlShortenerServiceImpl.shortenUrl() - UniqueId- ",convertUniqueString);
		logger.info("In UrlShortenerServiceImpl.shortenUrl() - tinyUrl- ",url);
		this.urlCache.getUrlCache().put(convertUniqueString, url);
	}

	private void saveToDB(String convertUniqueString, String url)
	{   
		Url urlEntity = new Url();
		urlEntity.setLongUrl(url);
		urlEntity.setUniqueKey(convertUniqueString);
		try {
			this.urlRepositoryService.saveUrl(urlEntity);
		} catch (Exception e) {
			
		}
		
	}

	public String getLongURLFromID(String url)
	{
		String longUrl = this.urlCache.getUrlCache().get(url);
		return longUrl;
	}

}

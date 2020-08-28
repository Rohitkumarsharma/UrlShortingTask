package com.urlshortener.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.urlshortener.model.Url;

@Repository
public class UrlRepositoryService {
	
	@Autowired
	private UrlRepository repository;
	
	public void saveUrl(Url url) throws Exception
	{
		repository.save(url);
	}

}

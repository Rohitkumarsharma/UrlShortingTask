package com.urlshortener.controller;



import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.urlshortener.service.UrlShortenerServiceImpl;
import com.urlshortener.util.Contants;
import com.urlshortener.util.UrlValidator;

@RestController
public class UrlShortenerController 
{
	private static final Logger logger = LoggerFactory.getLogger(UrlShortenerController.class);
	   
	@Autowired
	private UrlShortenerServiceImpl urlShortenerServiceImpl;
	
	@RequestMapping(value ="/shotenUrl" , method = {RequestMethod.POST} )
	public ResponseEntity<String> shotenUrlr(@RequestParam("url")String url)
	{
		
		boolean validateURL = UrlValidator.INSTANCE.validateURL(url);
		if(!validateURL) 
		{
			return ResponseEntity.badRequest().body(Contants.BAD_URL_ERROR);
		}
		else
		{
		   return	this.urlShortenerServiceImpl.shortenUrl(url);
		}
	}
	
	@RequestMapping(value ="/getUrl" , method = {RequestMethod.POST} )
	public ResponseEntity<String> getLongUrl(@RequestParam("url")String url)
	{
		
		boolean validateURL = UrlValidator.INSTANCE.validateURL(url);
		if(!validateURL) 
		{
			return ResponseEntity.badRequest().body(Contants.BAD_URL_ERROR);
		}
		else
		{
		   return	this.urlShortenerServiceImpl.shortenUrl(url);
		}
	}
	
	@RequestMapping(value = "/redirect/{url}", method=RequestMethod.GET)
    public RedirectView redirectUrl(@PathVariable String url, HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException, Exception {
        logger.info("Received shortened url to redirect: " + url);
        String redirectUrlString = urlShortenerServiceImpl.getLongURLFromID(url);
        logger.info("Original URL: " + redirectUrlString);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrlString);
        return redirectView;
    }
	
	
	
}

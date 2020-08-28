package com.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Url {
	
	@Id
	private int id;
	
	private String uniqueKey;
	
	private String longUrl;
	
	public Url() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUniqueKey() {
		return uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	
	
}

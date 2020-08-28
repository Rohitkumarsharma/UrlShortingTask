package com.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urlshortener.model.Url;

public interface UrlRepository extends JpaRepository<Url, String>
{

}

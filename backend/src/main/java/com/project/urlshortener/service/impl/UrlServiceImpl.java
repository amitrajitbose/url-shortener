package com.project.urlshortener.service.impl;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.UrlService;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Override
    public ShortenedUrlResponse shortenUrl(Request request) {
        ShortenedUrlResponse response = new ShortenedUrlResponse();
        response.setShortKey("test12");
        return response;
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return "http://example.com/";
    }
}

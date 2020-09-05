package com.project.urlshortener.service.impl;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.ShortenerService;
import org.springframework.stereotype.Service;

@Service
public class ShortenerServiceImpl implements ShortenerService {

    @Override
    public ShortenedUrlResponse shortenUrl(Request request) {
        ShortenedUrlResponse response = new ShortenedUrlResponse();
        response.setShortKey("test12");
        return response;
    }
}

package com.project.urlshortener.service;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;

public interface UrlService {

    ShortenedUrlResponse shortenUrl(Request request);

    String getLongUrl(String shortUrl);

}

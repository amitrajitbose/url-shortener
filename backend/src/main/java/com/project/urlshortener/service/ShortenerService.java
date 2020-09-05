package com.project.urlshortener.service;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;

public interface ShortenerService {
    ShortenedUrlResponse shortenUrl(Request request);

}

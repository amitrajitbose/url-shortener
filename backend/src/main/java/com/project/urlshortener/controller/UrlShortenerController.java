package com.project.urlshortener.controller;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.Response;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.ShortenerService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class UrlShortenerController {

    @Autowired
    private ShortenerService shortenerService;

    @PostMapping("/api/v1/")
    public final Response<ShortenedUrlResponse> shortenUrl(@Valid @RequestBody Request request){
        ShortenedUrlResponse response = shortenerService.shortenUrl(request);
        return new Response<>(Response.SUCCESS, "URL Shortened Successfully", response);
    }
}

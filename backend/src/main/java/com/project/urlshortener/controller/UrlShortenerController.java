package com.project.urlshortener.controller;

import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.UrlService;
import java.net.URI;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class UrlShortenerController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/api/v1/")
    public final ResponseEntity<ShortenedUrlResponse> shortenUrl(
        @Valid @RequestBody Request request) {
        ShortenedUrlResponse response = urlService.shortenUrl(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "{shortUrl}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl) {
        String longUrl = urlService.getLongUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
    }
}

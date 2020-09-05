package com.project.urlshortener.service.impl;

import com.project.urlshortener.constants.ApplicationConstants;
import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.URLConversionService;
import com.project.urlshortener.service.UrlService;
import com.project.urlshortener.utils.CommonUtils;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private URLConversionService urlConversionService;

    @Override
    public ShortenedUrlResponse shortenUrl(Request request) {
        if (!request.isCustom()) {
            String shortUrl = urlConversionService.convert(request.getLongUrl());
            Date current = CommonUtils.getCurrentDateTime();
            Date expiry = CommonUtils.getExpiryDateTime(current, ApplicationConstants.EXPIRY_YEARS);
            ShortenedUrlResponse shortenedUrlResponse = new ShortenedUrlResponse(shortUrl, current, expiry);
            // check in DB, if exists then repeat url generation
            // else insert in DB
            return shortenedUrlResponse;
        } else {
            // custom shortKey
            // check in DB, if exists then throw BE
            // else insert in DB
            return new ShortenedUrlResponse();
        }
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return "http://example.com/";
    }
}

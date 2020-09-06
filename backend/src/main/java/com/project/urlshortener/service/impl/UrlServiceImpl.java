package com.project.urlshortener.service.impl;

import com.project.urlshortener.constants.ApplicationConstants;
import com.project.urlshortener.dao.UrlDao;
import com.project.urlshortener.entity.UrlMapping;
import com.project.urlshortener.models.Request;
import com.project.urlshortener.models.ShortenedUrlResponse;
import com.project.urlshortener.service.URLConversionService;
import com.project.urlshortener.service.UrlService;
import com.project.urlshortener.utils.CommonUtils;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlDao urlDao;

    @Autowired
    private URLConversionService urlConversionService;

    @Override
    public ShortenedUrlResponse shortenUrl(Request request) {
        if (!request.isCustom()) {
            UrlMapping saved = null;
            do {
                String shortUrl = urlConversionService.convert(request.getLongUrl());
                Date current = CommonUtils.getCurrentDateTime();
                Date expiry = CommonUtils
                    .getExpiryDateTime(current, ApplicationConstants.EXPIRY_YEARS);

                // TODO: Handle with mapper
                UrlMapping urlMapping = new UrlMapping();
                urlMapping.setShortKey(shortUrl);
                urlMapping.setUrl(request.getLongUrl());
                urlMapping.setCreationDate(current);
                urlMapping.setExpirationDate(expiry);

                saved = saveMapping(urlMapping);
            } while (saved == null);

            // TODO: Handle with mapper
            ShortenedUrlResponse shortenedUrlResponse = new ShortenedUrlResponse(
                saved.getShortKey(), saved.getCreationDate(),
                saved.getExpirationDate());
            return shortenedUrlResponse;
        } else {
            // custom shortKey
            if (urlDao.findByShortKey(request.getShortKey()).size() == 0) {
                Date current = CommonUtils.getCurrentDateTime();
                Date expiry = CommonUtils
                    .getExpiryDateTime(current, ApplicationConstants.EXPIRY_YEARS);

                // TODO: Handle with mapper
                UrlMapping urlMapping = new UrlMapping();
                urlMapping.setShortKey(request.getShortKey());
                urlMapping.setUrl(request.getLongUrl());
                urlMapping.setCreationDate(current);
                urlMapping.setExpirationDate(expiry);

                UrlMapping saved = saveMapping(urlMapping);

                // TODO: Handle with mapper
                ShortenedUrlResponse shortenedUrlResponse = new ShortenedUrlResponse(
                    saved.getShortKey(), saved.getCreationDate(),
                    saved.getExpirationDate());
                return shortenedUrlResponse;
            }
            throw new RuntimeException("Key Already Exists. Try Something Else");
        }
    }

    @Override
    public String getLongUrl(String shortUrl) {
        List<UrlMapping> result = urlDao.findByShortKey(shortUrl);
        if (result.size() == 0){
            throw new RuntimeException("Error. Not Found");
        }
        return result.get(0).getUrl();
    }

    private UrlMapping saveMapping(UrlMapping url) {
        if (urlDao.findByShortKey(url.getShortKey()).size() > 0) {
            return null;
        }
        return urlDao.save(url);
    }
}

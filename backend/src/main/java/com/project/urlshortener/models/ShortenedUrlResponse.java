package com.project.urlshortener.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedUrlResponse {
    private String shortKey;
    private Date creationDate;
    private Date expirationDate;
}

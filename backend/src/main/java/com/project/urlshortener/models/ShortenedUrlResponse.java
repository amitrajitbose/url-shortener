package com.project.urlshortener.models;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShortenedUrlResponse {
    private String shortKey;
    private Date creationDate;
    private Date validUpto;
}

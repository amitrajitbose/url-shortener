package com.project.urlshortener.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedUrlResponse {
    private String shortKey;
    private Date creationDate;
    private Date validUpto;
}

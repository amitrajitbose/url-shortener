package com.project.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseError{
    private final String field;
    private final String message;
}

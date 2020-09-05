package com.project.urlshortener.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Request {
    @NotBlank(message = "URL cannot be empty")
    private String longUrl;

    private boolean custom;

    private String shortKey;
}

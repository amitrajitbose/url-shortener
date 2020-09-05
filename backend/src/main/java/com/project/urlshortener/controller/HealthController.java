package com.project.urlshortener.controller;

import com.project.urlshortener.models.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class HealthController {

    @GetMapping("/health")
    public final Response<String> successResponse() {
        final Runtime runtime = Runtime.getRuntime();
        final int mb = 1024 * 1024;
        String responseString =
            "Application Up & Running Successfully ! Total Memory: " + (runtime.totalMemory()
                / mb)
                + " MB , Free Memory: " + (runtime.freeMemory() / mb) + " MB";
        return new Response<>(Response.SUCCESS, responseString);
    }
}

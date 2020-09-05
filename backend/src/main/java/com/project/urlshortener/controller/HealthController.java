package com.project.urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class HealthController {

    @GetMapping("/health")
    public final ResponseEntity<String> successResponse() {
        final Runtime runtime = Runtime.getRuntime();
        final int mb = 1024 * 1024;
        String responseString =
            "Application Up & Running Successfully ! Total Memory: " + (runtime.totalMemory()
                / mb)
                + " MB , Free Memory: " + (runtime.freeMemory() / mb) + " MB";
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }
}

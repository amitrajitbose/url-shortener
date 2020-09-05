package com.project.urlshortener.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/*
 * Generic API Response DTO
 * @param <T>
 */
@Getter
public class Response<T> {

    // Constant Strings
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    // Will Be Sent Always
    private final String event;
    private final String message;

    // for success we return result body
    private final T result;
    private List<BaseError> errors;

    public Response(String event, String message, T result, Integer code, List<BaseError> errors) {
        this.event = event;
        this.message = message;
        this.result = result;
        this.errors = errors;
    }

    public Response() {
        this.event = null;
        this.message = null;
        this.result = null;
        this.errors = null;
    }

    public Response(String event) {
        this.event = event;
        this.message = null;
        this.result = null;
    }

    public Response(String event, String message) {
        this.event = event;
        this.message = message;
        this.result = null;
    }

    public Response(String event, String message, T result) {
        this.event = event;
        this.message = message;
        this.result = result;
    }

    public Response(String event, String message, List<BaseError> errors) {
        this.event = event;
        this.message = message;
        this.errors = errors;
        this.result = null;
    }

    public void addFieldErrors(final BaseError baseError) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(baseError);
    }
}
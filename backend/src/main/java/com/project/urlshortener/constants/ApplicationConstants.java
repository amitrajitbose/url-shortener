package com.project.urlshortener.constants;

public final class ApplicationConstants {

    public static final int SHORT_URL_LENGTH = 6;
    public static final String TIME_ZONE = "UTC";
    public static final Long EXPIRY_YEARS = 5L;

    private ApplicationConstants() {
        throw new AssertionError("Sorry! Class cannot be instantiated.");
    }
}

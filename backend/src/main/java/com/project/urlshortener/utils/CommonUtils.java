package com.project.urlshortener.utils;

import com.project.urlshortener.constants.ApplicationConstants;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtils {
    public static Timestamp getCurrentDateTime(){
        TimeZone tz = TimeZone.getTimeZone(ApplicationConstants.TIME_ZONE);
        Instant nowUtc = Instant.now();
        return new Timestamp(nowUtc.toEpochMilli());
    }

    public static Timestamp getExpiryDateTime(Date current, Long years){
        LocalDateTime time = LocalDateTime.ofInstant(current.toInstant(), ZoneOffset.ofHours(0));
        time = time.plusYears(years);
        return new Timestamp(time.atZone(ZoneOffset.ofHours(0)).toInstant().toEpochMilli());
    }
}

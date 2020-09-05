package com.project.urlshortener.service.impl;

import com.project.urlshortener.constants.ApplicationConstants;
import com.project.urlshortener.service.URLConversionService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

@Service
public class MyMD5Converter implements URLConversionService {

    @Override
    public String convert(String longUrl) {
        String md5 = getMD5Hash(longUrl);
        StringBuffer shortKey = new StringBuffer(ApplicationConstants.SHORT_URL_LENGTH);
        List<Integer> randoms = getRandomNumbers(ApplicationConstants.SHORT_URL_LENGTH, 0,
            md5.length());
        for (Integer i : randoms) {
            shortKey.append(md5.charAt(i));
        }
        return shortKey.toString();
    }

    private String getMD5Hash(String input) {
        return DigestUtils.md5Hex(input);
    }

    /**
     * This is exclusive to upper. Generates `count` random and unique numbers between lower and
     * upper (excluding upper)
     */
    private List<Integer> getRandomNumbers(int count, int lower, int upper) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int r;
        do {
            r = (int) (Math.random() * (upper - lower)) + lower;
            if (!result.contains(r)) {
                result.add(r);
            }
        } while (result.size() < count);
        return result;
    }
}

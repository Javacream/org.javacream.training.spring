package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public abstract class BaseIsbnGeneratorService implements IsbnGeneratorService {
    @Value("${isbngenerator.prefix}")
    private String prefix;
    @Value("${isbngenerator.countryCode}")
    private String countryCode;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String next() {
        return prefix + createId() + countryCode;
    }

    public abstract String createId();
}

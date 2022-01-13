package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;

import java.util.Random;

public abstract class BaseIsbnGeneratorService implements IsbnGeneratorService {
    private String prefix;
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

package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@IsbnGenerator.SequenceStrategy
public class CounterIsbnGenerator implements IsbnGenerator {

    @Value("${isbngenerator.prefix}")
    private String prefix;
    @Value("${isbngenerator.countryCode}")
    private String countryCode;
    @Autowired
    private SequenceGenerator sequenceGenerator;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String suffix) {
        this.countryCode = suffix;
    }

    public String next() {
        return prefix + sequenceGenerator.nextSequence() + countryCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

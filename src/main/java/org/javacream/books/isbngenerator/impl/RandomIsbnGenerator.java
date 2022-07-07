package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("singleton")
@IsbnGenerator.RandomStrategy
public class RandomIsbnGenerator implements IsbnGenerator {

    private final String prefix;
    private final String countryCode;
    private final Random random;

    {
        random = new Random(this.hashCode() + System.currentTimeMillis());
    }

    public RandomIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.countryCode}") String countryCode) {
        this.prefix = prefix;
        this.countryCode = countryCode;
    }

    public String next() {
        return prefix + random.nextInt() + countryCode;
    }

}

package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;

import java.util.Random;

public class RandomIsbnGeneratorService implements IsbnGeneratorService {
    private Random random = new Random();
    @Override
    public String next() {
        return "Isbn:" + random.nextInt();
    }
}

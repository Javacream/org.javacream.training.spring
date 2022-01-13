package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;

import java.util.Random;

public class RandomIsbnGeneratorService extends BaseIsbnGeneratorService {
    private Random random = new Random();
    @Override
    public String createId() {
        return Integer.toString(random.nextInt());
    }
}

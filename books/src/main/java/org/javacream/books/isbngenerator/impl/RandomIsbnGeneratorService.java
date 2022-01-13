package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomIsbnGeneratorService extends BaseIsbnGeneratorService {
    private Random random = new Random();
    @Override
    public String createId() {
        return Integer.toString(random.nextInt());
    }
}

package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;

public class SequenceIsbnGeneratorService implements IsbnGeneratorService {
    private Integer counter = 0;
    @Override
    public String next() {
        counter++;
        return "Isbn:" + counter;
    }
}

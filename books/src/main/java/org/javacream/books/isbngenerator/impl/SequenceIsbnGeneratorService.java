package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.springframework.stereotype.Service;

@Service
@IsbnGeneratorService.SequenceStrategy
public class SequenceIsbnGeneratorService extends BaseIsbnGeneratorService {
    private Integer counter = 0;
    @Override
    public String createId() {
        counter++;
        return Integer.toString(counter);
    }
}

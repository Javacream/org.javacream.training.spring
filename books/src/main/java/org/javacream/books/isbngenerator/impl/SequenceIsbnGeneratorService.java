package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGeneratorService;
import org.javacream.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@IsbnGeneratorService.SequenceStrategy
public class SequenceIsbnGeneratorService extends BaseIsbnGeneratorService {
    @Autowired private IdGenerator idGenerator;
    @Override
    public String createId() {
        return Long.toString(idGenerator.nextId());
    }
}

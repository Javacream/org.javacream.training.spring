package org.javacream.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    @Value("${idGenerator.start}") private long counter;
    public long next(){
        return counter++;
    }
}

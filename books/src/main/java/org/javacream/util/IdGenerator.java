package org.javacream.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class IdGenerator {
    private Long counter = 0l;
    public Long nextId(){
        return ++counter;
    }
}

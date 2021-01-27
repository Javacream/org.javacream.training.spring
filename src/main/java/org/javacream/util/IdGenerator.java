package org.javacream.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class IdGenerator {
    private Random random;

    @PostConstruct public void init() {
        random = new Random(this.hashCode() + System.currentTimeMillis());
    }
    public long id(){
        return random.nextLong();
    }
}

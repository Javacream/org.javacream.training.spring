package org.javacream.training;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class NullTests {
    private String s2; //Default-Initialisierung = "Binär null"
    @Test public void testNullReference(){
        String s = null;//"Sawitzki";
        if (s != null) {
            System.out.println(s.length());
        }
    }

    @Test public void testOptional(){
        Optional<String> s = Optional.empty();//"Sawitzki";
        if (s.isPresent()) {
            System.out.println(s.get().length());
        }

    }

}

package org.javacream.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;

public class CollectionsTest {
    @Test public void testList(){
        List<String> names = new LinkedList<>(); //ab Java 11: List<String> names = List.of("", "");
        names.add("Hugo");
        names.add("Emil");
        names.add("Fritz");
        names.add("Hugo");
        Assertions.assertEquals(4, names.size());
        Assertions.assertTrue(names.contains("Hugo"));
        Assertions.assertFalse(names.contains("edurd"));
        names.clear();
        Assertions.assertEquals(0, names.size());
    }
    @Test public void testSet(){
        Set<String> names = new HashSet<>();
        names.add("Hugo");
        names.add("Emil");
        names.add("Fritz");
        names.add("Hugo");
        Assertions.assertEquals(3, names.size());
        Assertions.assertTrue(names.contains("Hugo"));
        Assertions.assertFalse(names.contains("edurd"));
        names.clear();
        Assertions.assertEquals(0, names.size());
    }

    @Test public void testMap(){
        Map<Integer, String> postalCodesToCity = new HashMap<>();
        postalCodesToCity.put(81373, "Muenchen");
        postalCodesToCity.put(30111, "Berlin");
        postalCodesToCity.put(81373, "München");
        Assertions.assertEquals(2, postalCodesToCity.size());
        Assertions.assertTrue(postalCodesToCity.containsKey(81373));
        Assertions.assertTrue(postalCodesToCity.containsValue("Berlin"));
        postalCodesToCity.clear();
        Assertions.assertEquals(0, postalCodesToCity.size());
        Map<Integer, Set<String>> postalCodesToCityextended = new HashMap<>();

    }

    @Test public void testIteration(){
        Set<String> names = new HashSet<>();
        names.add("Hugo");
        names.add("Emil");
        names.add("Fritz");
    /*
        Consumer<String> printer = (String s) -> {
                System.out.println(s);
        };
        names.forEach(printer);
        */
        names.forEach((s) -> System.out.println(s));
    }

}

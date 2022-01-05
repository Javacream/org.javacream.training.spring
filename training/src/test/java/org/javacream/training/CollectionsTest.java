package org.javacream.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        names.forEach(System.out::println);
        names.forEach(Hotel::egal);

    }

    @Test public void testStreaming(){
        Set<String> names = new HashSet<>();
        names.add("Hugo");
        names.add("Emil");
        names.add("Fritzi");
        names.add("Eduard");
        names.add("Felix");
        names.add("Hannah");
        //Stream<String> namesStream = names.stream();
        //Stream<String> filteredNames = namesStream.filter((name) -> {return name.startsWith("F");});
        //filteredNames.forEach(System.out::println);
        //names.stream().filter((name) -> {return name.startsWith("F");}).forEach(System.out::println);
       // names.stream().filter(name -> name.startsWith("F")).forEach(System.out::println);
        //names.stream().map(name -> name.length()).forEach(System.out::println);
        //names.stream().filter(name -> name.startsWith("F")).map(name -> name.length()).forEach(System.out::println);
        List<Integer> result = names.stream().filter(name -> name.startsWith("F")).map(name -> name.length()).collect(Collectors.toList());
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(5));
        Assertions.assertTrue(result.contains(6));
    }

}

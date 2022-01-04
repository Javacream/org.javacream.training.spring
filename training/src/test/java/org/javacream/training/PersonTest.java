package org.javacream.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void personTest(){
        String lastname = "Sawitzki";
        String firstname = "Rainer";
        Person person = new Person(lastname, firstname);
        Assertions.assertEquals(lastname, person.getLastname());
        Assertions.assertEquals(firstname, person.getFirstname());
    }

    @Test
    public void personTestWithAddress(){
        String lastname = "Sawitzki";
        String firstname = "Rainer";
        Person person = new Person(lastname, firstname);
        Person p2 = person;
        Person p3 = p2;

        Assertions.assertNull(person.getAddress());
        Address sawitzkiAdress = new Address("München", "Marienplatz");
        p3.setAddress(sawitzkiAdress);
        Assertions.assertEquals(sawitzkiAdress, person.getAddress());
        sawitzkiAdress.setCity("Berlin");
        Assertions.assertEquals("Berlin", person.getAddress().getCity());


    }
    @Test
    public void types() {
        int number = 42;
        Integer number2 = new Integer(42);
        Integer number3 = 42;
        int number4 = new Integer(42);


        Integer number5 = number3;
        number3 = 4711;
    }

    @Test public void testInheritance(){
        Person p = new Person("meier", "hans");
        Student s = new Student("Einstein", "Albert", "LMU");
        Worker w = new Worker("Schufter", "Hans", "Integrata");
        Student s2 = new Student("Curie", "Albert", "LMU");

    }

    @Test public void testStatic(){
        System.out.println(Person.NUMBER_OF_EYES);

    }

}

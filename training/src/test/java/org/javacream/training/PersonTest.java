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
        Assertions.assertNull(person.getAddress());
        Address sawitzkiAdress = new Address("München", "Marienplatz");
        person.setAddress(sawitzkiAdress);
        Assertions.assertEquals(sawitzkiAdress, person.getAddress());
        sawitzkiAdress.setCity("Berlin");
        Assertions.assertEquals("Berlin", person.getAddress().getCity());


    }

    @Test public void testInheritance(){
        Person p = new Person("meier", "hans");
        Student s = new Student("Einstein", "Albert", "LMU");
        Worker w = new Worker("Schufter", "Hans", "Integrata");
        Student s2 = new Student("Curie", "Albert", "LMU");
        print(p);
        print(s);
        print(w);
    }

    private void print(Person person){
        System.out.println(person.info());
    }
    @Test public void testStatic(){
        System.out.println(Person.NUMBER_OF_EYES);

    }

    @Test public void testMariageAndDivorce(){
        Person sawitzki = new Person("Sawitzki", "Rainer");
        Person meier = new Person("Meier", "Jamie");
        Person schneider = new Person("schneider", "Nicola");
        Assertions.assertNull(sawitzki.getPartner());
        Assertions.assertSame(true, sawitzki.marry(meier));
        Assertions.assertFalse(schneider.marry(null));
        Assertions.assertFalse(schneider.marry(schneider));
        Assertions.assertFalse(schneider.marry(sawitzki));
        Assertions.assertSame(meier, sawitzki.getPartner());
        Assertions.assertSame(sawitzki, meier.getPartner());
        Assertions.assertTrue(sawitzki.divorce());
        Assertions.assertFalse(schneider.divorce());
        Assertions.assertSame(null, sawitzki.getPartner());
        Assertions.assertSame(null, meier.getPartner());
    }
}

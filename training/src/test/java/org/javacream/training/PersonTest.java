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
        Assertions.assertFalse(sawitzki.marry(schneider));
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

    @Test public void testInterfaces(){
        Person sawitzki = new Person("Sawitzki", "Rainer");
        Address sawitzkiAdress = new Address("München", "Marienplatz");
        sawitzki.setAddress(sawitzkiAdress);
        Hotel hotel = new Hotel("Ibis", 200, new Address("Berlin", "Alexanderplatz"));
//        System.out.println(sawitzki.getAddress());
//        System.out.println(hotel.getAddress());
        printAddress(sawitzki);
        printAddress(hotel);

    }

    private void printAddress(Addressable addressable){
        System.out.println(addressable.getAddress());
    }

    @Test public void testHotel(){
        Person sawitzki = new Person("Sawitzki", "Rainer");
        Person meier = new Person("Meier", "Jamie");
        Person schneider = new Person("schneider", "Nicola");
        Hotel hotel = new Hotel("Ibis", 2, new Address("Berlin", "Alexanderplatz"));
        Assertions.assertTrue(hotel.checkIn(sawitzki));
        Assertions.assertFalse(hotel.checkIn(sawitzki));
        Assertions.assertTrue(hotel.checkIn(meier));
        Assertions.assertFalse(hotel.checkIn(schneider));
        Assertions.assertTrue(hotel.checkOut(sawitzki));
        Assertions.assertFalse(hotel.checkOut(sawitzki));
        Assertions.assertTrue(hotel.checkIn(schneider));
        /*for (Person p: hotel.getCheckedIn()){
            System.out.println(p.info());
        }*/
        hotel.getCheckedIn().forEach((p) -> System.out.println(p.info()));



    }
}

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
        Assertions.assertEquals(sawitzkiAdress, person.getAddress().get());
        sawitzkiAdress.setCity("Berlin");
        Assertions.assertEquals("Berlin", person.getAddress().get().getCity());


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
        try {
            sawitzki.marry(meier);
        }
        catch(PersonException pe){
            //...
        }

        Assertions.assertThrows(PersonException.class, () -> sawitzki.marry(schneider));
        Assertions.assertThrows(PersonException.class, () -> schneider.marry(null));
        Assertions.assertThrows(PersonException.class, () -> schneider.marry(schneider));
        Assertions.assertThrows(PersonException.class, () -> schneider.marry(sawitzki));
        Assertions.assertSame(meier, sawitzki.getPartner());
        Assertions.assertSame(sawitzki, meier.getPartner());
        try {
            sawitzki.divorce();
        } catch (PersonException e) {
            e.printStackTrace();
        }
        Assertions.assertThrows(PersonException.class, () -> schneider.divorce());
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
        Person schneider = new Person("Schneider", "Nicola");
        Student einstein = new Student("Einstein", "Albert", "LMU");
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
        hotel.checkOut(meier);
        hotel.checkIn(einstein);
        hotel.getCheckedIn().forEach((p) -> System.out.println(p.info()));
        hotel.getGuestList().forEach(System.out::println);
        hotel.getSortedByLastnameGuestList().forEach(System.out::println);
        hotel.getStudentGuestList().forEach(System.out::println);


    }
}

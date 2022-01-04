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
        Address address = new Address("München", "Marienplatz");
        person.setAddress(address);
        Assertions.assertEquals(address, person.getAddress());

    }

}

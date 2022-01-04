package org.javacream.training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void personTest(){
        String lastname = "Sawitzki";
        String firstname = "Rainer";
        Person person = new Person(lastname, firstname);
        //System.out.println(person.info());
        Assertions.assertEquals(lastname, person.getLastname());
        Assertions.assertEquals(firstname, person.getFirstname());

    }
}

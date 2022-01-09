package org.javacream.training;

import java.util.Objects;
import java.util.Optional;

public class Person implements Addressable{
    private String lastname;
    private String firstname;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private Gender gender;

    public static final Integer NUMBER_OF_EYES = 2;

    public Person getPartner() {
        return partner;
    }

    private Person partner;
    public void marry(Person bride) throws PersonException{
        if (this.partner != null){
            throw new PersonException("cannot marry, already married!");
        }
        if (bride == null){
            throw new PersonException("cannot marry null!");
        }
        if (bride == this){
            throw new PersonException("cannot marry myself!");
        }
        if (bride.partner != null){
            throw new PersonException("cannot marry, partner is married!");
        }

        this.partner = bride;
        bride.partner = this;
    }

    public void divorce() throws PersonException{
        if (this.partner == null){
            throw new PersonException("cannot divorce, have no partner!");
        }
        this.partner.partner = null;
        this.partner = null;
    }

    public static Integer getNumberOfEyes(){
        //this.lastname;
        return NUMBER_OF_EYES;
    }
    public Optional<Address> getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = Optional.of(address);
    }

    private Optional<Address> address;
    public String info(){
        return "Person: lastname=" + this.lastname + ", firstname=" + this.firstname;
    }

    public Person(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(lastname, person.lastname) && Objects.equals(firstname, person.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname);
    }
}

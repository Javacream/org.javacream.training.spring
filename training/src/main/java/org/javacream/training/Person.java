package org.javacream.training;

import java.util.Objects;

public class Person{
    private String lastname;
    private String firstname;
    public static final Integer NUMBER_OF_EYES = 2;

    public Person getPartner() {
        return partner;
    }

    private Person partner;
    public Boolean marry(Person partner){
        if (partner == null){
            System.out.println("cannot marry null!");
            return false;
        }
        if (partner == this){
            System.out.println("cannot marry myself!");
            return false;
        }
        if (partner.partner != null){
            System.out.println("cannot marry, partner is married!");
            return false;
        }

        this.partner = partner;
        partner.partner = this;
        return true;
    }

    public Boolean divorce(){
        if (this.partner == null){
            System.out.println("cannot divorce, have no partner!");
            return false;
        }
        this.partner.partner = null;
        this.partner = null;
        return true;
    }

    public static Integer getNumberOfEyes(){
        //this.lastname;
        return NUMBER_OF_EYES;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;
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

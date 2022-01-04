package org.javacream.training;

public class Worker extends Person {
    private String company;
    public Worker(String lastname, String firstname, String company) {
        super(lastname, firstname);
        this.company = company;
    }

    public void work(){
        System.out.println(this.info() + " is WORKING at " + this.company);
    }
}

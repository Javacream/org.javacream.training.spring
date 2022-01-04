package org.javacream.training;

public class Student extends Person {
    private String university;
    public Student(String lastname, String firstname, String university) {
        super(lastname, firstname);
        this.university = university;
    }

    public void study(){
        System.out.println(this.info() + " is studying at " + this.university);
    }
}

package org.javacream.training;

import java.util.Objects;

public class Student extends Person {
    private String university;
    public Student(String lastname, String firstname, String university) {
        super(lastname, firstname);
        this.university = university;
    }

    public void study(){
        System.out.println(this.info() + " is studying at " + this.university);
    }

    @Override
    public String info(){
        return super.info() + " is studying at " + this.university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }

    @Override
    public String toString() {
        return super.toString() + ", Student{" +
                "university='" + university + '\'' +
                '}';
    }
}

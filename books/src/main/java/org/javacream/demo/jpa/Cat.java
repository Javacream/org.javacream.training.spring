package org.javacream.demo.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="CatEntity")
@Table(name="CATS")
//@Entity(name="Dog") //Im Standard: Der Klassenname ohne package, also hier: Cat
//@Table(name="CATS") //Im Standard: Die Tabelle heißt wie die Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Cat(){}

    public Cat(String name, double weight, String furColor) {
        this.name = name;
        this.weight = weight;
        this.furColor = furColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    //@Column(name="Hugo") //Standard: Name des Attributs
    @Column(name="CAT_NAME")
    private String name;
    //@Column(Tabellendefinition inklusive Typ und Constraints) ??? Das sind doch nur Informationen die zum Erstellen der Tabelle genutzt werden
    private double weight;
    @Column(name="color")
    private String furColor;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", furColor='" + furColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(cat.weight, weight) == 0 && Objects.equals(name, cat.name) && Objects.equals(furColor, cat.furColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, furColor);
    }

    public String annoy(){
        return "miau!";
    }
}

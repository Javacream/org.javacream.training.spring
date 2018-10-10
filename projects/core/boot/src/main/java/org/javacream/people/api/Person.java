package org.javacream.people.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PEOPLE")
public class Person {
	
	private String lastname;
	
	private String firstname;
	private int height;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	public Person() {
	}
	public Person(String lastname, String firstname, int height) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.height = height;
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
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}

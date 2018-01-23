package com.jersey.spring.hibernate.server.model.tableperclasshierarchey;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "dog")
public class Dog extends Animal {

	private int age;
	
	public Dog() {
		
	}

	/**
	 * @param age
	 */
	public Dog(int age) {
		this.age = age;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}
}

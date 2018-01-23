package com.jersey.spring.hibernate.server.model.tableperclasshierarchey;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cat")
public class Cat extends Animal {

	private String color;

	public Cat() {
		
	}
	/**
	 * @param color
	 */
	public Cat(String color) {
		this.color = color;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cat [color=" + color + "]";
	}
}

package com.jersey.spring.hibernate.server.model.tableperconcreteclass;

import javax.persistence.Entity;

@Entity
public class Phones extends Mobile {

	private String color;

	public Phones() {
		
	}
	
	/**
	 * @param color
	 */
	public Phones(String color) {
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
		return "Phones [color=" + color + "]";
	}
	
	
}

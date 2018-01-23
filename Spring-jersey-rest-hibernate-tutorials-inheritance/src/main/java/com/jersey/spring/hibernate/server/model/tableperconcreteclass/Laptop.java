package com.jersey.spring.hibernate.server.model.tableperconcreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Laptop extends OperatingSystem{

	@Column(name = "laptop_name")
	private String name;
	
	@Column(name = "laptop_price")
	private float price;
	
	public Laptop() {
		
	}

	/**
	 * @param name
	 * @param price
	 */
	public Laptop(String name, float price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Laptop [name=" + name + ", price=" + price + "]";
	}
	
}

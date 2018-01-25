package com.jersey.spring.hibernate.server.model.mappedBy;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * This is not an entity class. 
 * since this class will be used as parent class for other class because this class 
 * holds the common resources.
 * There is no table creation done by hibernate for this class.
 * 
 * advantages : 
 * 1.
 * we will share common resources of this class with other entity class without 
 * creating a table of this class using inheritance.
 * 
 * disadvantages : -
 *1.  
 * This strategy is not good if we query using parent class.
 * since hibernate will fire many query which unnecessary 
 * as per requirement.
 * 
 * 2. 
 * we cannot perform polymorphic queries.
 * 
 * @author raviranjan
 *
 */

@MappedSuperclass
public abstract class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;
	
	@Column(name = "name")
	protected String name;
	
	@Column(name = "company")
	protected String company;

	public Employee() {
		
	}
	
	/**
	 * @param name
	 * @param company
	 */
	public Employee(String name, String company) {
		this.name = name;
		this.company = company;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	
}

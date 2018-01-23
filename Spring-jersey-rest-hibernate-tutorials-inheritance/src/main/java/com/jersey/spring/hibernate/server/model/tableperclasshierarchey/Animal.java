package com.jersey.spring.hibernate.server.model.tableperclasshierarchey;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * This is the entity class.
 * only table for this class exists.
 * all of its children will be a part of column data in the this table.
 * we use @DiscriminatorColumn to just identity that this rows belong to which sub-class.
 * 
 * Advantages : -
 * 
 * Fast - no joins are needed to retrieve data
 * Simple - only single table is needed in database
 * This approach makes polymorphic queries very efficient and provides the best performance.
 * 
 * Disadvantages : -
 * 
 * 1. Cannot create constrains in database - all columns representing subclass data must be nullable. 
 * 2. This is serious drawback because without constrains data can be easily corrupted 
 * by application bug or by inattentive users.
 * 3. Wasted space - when subclasses have many fields shared table will contain many columns most of 
 * which will contain NULLs
 * 4. Each record uses only a subset of the available columns and sets the rest of them to null. 
 * You can, therefore, not use not null constraints on any column that isn’t mapped to all entities. 
 * @author raviranjan
 *
 */
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "animal_type")
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public Animal() {

	}
	/**
	 * @param name
	 */
	public Animal(String name) {
		this.name = name;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + "]";
	}
}

package com.jersey.spring.hibernate.server.model.tableperconcreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * This is the root class.
 * 
 * To enable table per concrete class strategy : - 
 * root of the inheritance hierarchy must be marked as 
 * @Entity and must have  @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) annotation. 
 * All subclasses (even abstract ones) must be marked as @Entity. 
 * Abstract classes will not be represented in database.
 * 
 * Hibernate uses SQL subquery and union all operator to gather rows from all tables containing subclasses data. 
 * To differentiate between subclasses in the result set, Hibernate adds special column clazz_ that will contain different numbers for different subclasses:
 * 
 * pros : -
 * 
 * Constraint friendly - You can introduce separate database constrains for each concrete subclass.
 * Fast when querying concrete subclasses (queries directly access subclass table)
 * 
 * Cons : -
 * May be slow when you query/lazy load abstract super classes (union all and subquery)
 * Cannot introduce foreign key constrains for super classes references (like in  Photo example)
 * 
 * @author raviranjan
 *
 */
@Entity
@Table(name = "Table_Per_Concrete_Class")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class OperatingSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@Column(name = "operating_system")
	private String os;
	
	public OperatingSystem() {
		
	}

	/**
	 * @param id
	 * @param os
	 */
	public OperatingSystem(String os) {
		this.os = os;
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
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OperatingSystem [id=" + id + ", os=" + os + "]";
	}
}

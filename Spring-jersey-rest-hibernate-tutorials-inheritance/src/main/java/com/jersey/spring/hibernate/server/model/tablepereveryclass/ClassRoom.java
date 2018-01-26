package com.jersey.spring.hibernate.server.model.tablepereveryclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "class_room_id")
@Table(name = "class_room")
public abstract class ClassRoom extends School{

	@Column(name = "class_name")
	private String className;
	
	public ClassRoom() {
		
	}

	/**
	 * @param className
	 */
	public ClassRoom(String className) {
		this.className = className;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassRoom [className=" + className + "]";
	}
}

package com.jersey.spring.hibernate.server.model.tableperconcreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public abstract class Mobile extends OperatingSystem{

	@Column(name = "mobile_name")
	private String mobileName;
	
	public Mobile() {
		
	}

	/**
	 * @param mobileName
	 */
	public Mobile(String mobileName) {
		this.mobileName = mobileName;
	}

	/**
	 * @return the mobileName
	 */
	public String getMobileName() {
		return mobileName;
	}

	/**
	 * @param mobileName the mobileName to set
	 */
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mobile [mobileName=" + mobileName + "]";
	}

	
}

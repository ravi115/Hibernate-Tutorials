package com.jersey.spring.hibernate.server.model.tablepereveryclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class Library extends School {

	@Column(name = "library_name")
	private String libraryName;
	
	public Library() {
		
	}

	/**
	 * @param libraryName
	 */
	public Library(String libraryName) {
		this.libraryName = libraryName;
	}

	/**
	 * @return the libraryName
	 */
	public String getLibraryName() {
		return libraryName;
	}

	/**
	 * @param libraryName the libraryName to set
	 */
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + "]";
	}
}

package com.jersey.spring.hibernate.server.model.mappedBy;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract_employee")
public class ContractEmployee extends Employee {

	private String version;
	
	private String city;
	
	public ContractEmployee() {
		
	}

	/**
	 * @param version
	 * @param city
	 */
	public ContractEmployee(String version, String city) {
		this.version = version;
		this.city = city;
	}


	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContractEmployee [version=" + version + ", city=" + city + ", id=" + id + ", name=" + name
				+ ", company=" + company + "]";
	}
	
}

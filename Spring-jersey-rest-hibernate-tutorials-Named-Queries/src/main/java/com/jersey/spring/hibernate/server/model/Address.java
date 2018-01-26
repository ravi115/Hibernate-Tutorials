package com.jersey.spring.hibernate.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "address")
//This is HQL ways of query
@NamedQueries(
		{
			@NamedQuery
			(
					name = "HQL_GET_ALL_ADDRESS", 
					query = "from Address"
			),
			@NamedQuery(
					name = "HQL_GET_ADDRESS_FOR_ID", 
					query = "from Address where id=:id"
			)
		})

//This is used where we write SQL Based Query.
@NamedNativeQueries(
		{
			@NamedNativeQuery
			(
					name = "SQL_GET_ALL_ADDRESS", 
					query = "select colony, city,state,pincode,country"
												+ " from Address"
			)
		}
	)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int id;
	
	@Column(name = "colony")
	private String colony;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "country")
	private String country;
	
	public Address() {
		
	}

	/**
	 * @param colony
	 * @param city
	 * @param state
	 * @param pincode
	 * @param country
	 */
	public Address(String colony, String city, String state, int pincode, String country) {
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
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
	 * @return the colony
	 */
	public String getColony() {
		return colony;
	}

	/**
	 * @param colony the colony to set
	 */
	public void setColony(String colony) {
		this.colony = colony;
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

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", colony=" + colony + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", country=" + country + "]";
	}
}

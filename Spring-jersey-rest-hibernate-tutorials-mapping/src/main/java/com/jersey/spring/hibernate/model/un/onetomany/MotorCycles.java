package com.jersey.spring.hibernate.model.un.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motor_cycle")
public class MotorCycles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "bike_name")
	private String bikeName;
	
	@Column(name = "bike_type")
	private String bikeType;
	
	public MotorCycles() {
		
	}

	/**
	 * @param bikeName
	 * @param bikeType
	 */
	public MotorCycles(String bikeName, String bikeType) {
		this.bikeName = bikeName;
		this.bikeType = bikeType;
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
	 * @return the bikeName
	 */
	public String getBikeName() {
		return bikeName;
	}

	/**
	 * @param bikeName the bikeName to set
	 */
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	/**
	 * @return the bikeType
	 */
	public String getBikeType() {
		return bikeType;
	}

	/**
	 * @param bikeType the bikeType to set
	 */
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
	
	
	
}

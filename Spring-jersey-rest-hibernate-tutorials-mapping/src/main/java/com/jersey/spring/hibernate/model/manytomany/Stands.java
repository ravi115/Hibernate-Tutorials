package com.jersey.spring.hibernate.model.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stands")
public class Stands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "stand_name")
	private String standName;
	
	@Column(name= "lat")
	private double latitude;
	
	@Column(name= "lng")
	private double longitude;
	
	public Stands() {}

	/**
	 * @param standName
	 * @param latitude
	 * @param longitude
	 */
	public Stands(String standName, double latitude, double longitude) {
		this.standName = standName;
		this.latitude = latitude;
		this.longitude = longitude;
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
	 * @return the standName
	 */
	public String getStandName() {
		return standName;
	}

	/**
	 * @param standName the standName to set
	 */
	public void setStandName(String standName) {
		this.standName = standName;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
}

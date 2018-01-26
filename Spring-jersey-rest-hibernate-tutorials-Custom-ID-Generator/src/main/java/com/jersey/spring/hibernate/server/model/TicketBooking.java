package com.jersey.spring.hibernate.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ticket_booking")
public class TicketBooking {

	@Id
	@GenericGenerator(name = "custom_id", 
						strategy = "com.jersey.spring.hibernate.server.id.generator.CustomIdentifier")
	@GeneratedValue(generator = "custom_id")
	@Column(name = "movie_id", unique = true)
	private String id;
	
	@Column(name = "Number_of_tickets")
	private int numberOfTickets;
	
	@Column(name = "movie")
	private String movie;
	
	@Column(name = "Theater_name")
	private String theaterName;
	
	@Column(name = "city")
	private String city;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	public TicketBooking() {
		
	}

	/**
	 * @param numberOfTickets
	 * @param movie
	 * @param theaterName
	 * @param city
	 * @param createdAt
	 */
	public TicketBooking(int numberOfTickets, String movie, String theaterName, String city, Date createdAt) {
		this.numberOfTickets = numberOfTickets;
		this.movie = movie;
		this.theaterName = theaterName;
		this.city = city;
		this.createdAt = createdAt;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the numberOfTickets
	 */
	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	/**
	 * @param numberOfTickets the numberOfTickets to set
	 */
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	/**
	 * @return the movie
	 */
	public String getMovie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(String movie) {
		this.movie = movie;
	}

	/**
	 * @return the theaterName
	 */
	public String getTheaterName() {
		return theaterName;
	}

	/**
	 * @param theaterName the theaterName to set
	 */
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
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
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketBooking [id=" + id + ", numberOfTickets=" + numberOfTickets + ", movie=" + movie
				+ ", theaterName=" + theaterName + ", city=" + city + ", createdAt=" + createdAt + "]";
	}

}

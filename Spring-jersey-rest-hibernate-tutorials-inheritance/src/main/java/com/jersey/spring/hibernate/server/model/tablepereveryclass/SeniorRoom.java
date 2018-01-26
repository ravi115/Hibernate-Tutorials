package com.jersey.spring.hibernate.server.model.tablepereveryclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "senior_class_room")
public class SeniorRoom extends ClassRoom {

	@Column(name = "room_number")
	private int roomNumber;
	
	public SeniorRoom() {
		
	}

	/**
	 * @param roomNumber
	 */
	public SeniorRoom(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SeniorRoom [roomNumber=" + roomNumber + "]";
	}
}

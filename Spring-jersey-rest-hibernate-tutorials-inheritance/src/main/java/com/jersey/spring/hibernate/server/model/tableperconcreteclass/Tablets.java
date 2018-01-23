package com.jersey.spring.hibernate.server.model.tableperconcreteclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Tablets extends Mobile {

	@Column(name = "screen_size")
	private float screenSize;

	public Tablets() {
		
	}
	
	/**
	 * @param screenSize
	 */
	public Tablets(float screenSize) {
		this.screenSize = screenSize;
	}

	/**
	 * @return the screenSize
	 */
	public float getScreenSize() {
		return screenSize;
	}

	/**
	 * @param screenSize the screenSize to set
	 */
	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tablets [screenSize=" + screenSize + "]";
	}
	
	
}

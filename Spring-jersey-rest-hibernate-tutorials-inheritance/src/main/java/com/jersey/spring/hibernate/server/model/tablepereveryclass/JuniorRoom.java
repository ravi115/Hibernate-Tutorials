package com.jersey.spring.hibernate.server.model.tablepereveryclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "junior_class_room")
public class JuniorRoom extends ClassRoom {

	@Column(name = "class_standard")
	private int classStandard;
	
	public JuniorRoom() {
		
	}

	/**
	 * @param classStandard
	 */
	public JuniorRoom(int classStandard) {
		this.classStandard = classStandard;
	}

	/**
	 * @return the classStandard
	 */
	public int getClassStandard() {
		return classStandard;
	}

	/**
	 * @param classStandard the classStandard to set
	 */
	public void setClassStandard(int classStandard) {
		this.classStandard = classStandard;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JuniorRoom [classStandard=" + classStandard + "]";
	}
}

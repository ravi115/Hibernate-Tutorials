package com.jersey.spring.hibernate.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "data_type")
public class JavaDataTypesModel {

	@Column(name = "Byte_data_type")
	private byte byteVal;
	
	@Column(name = "Short_data_type")
	private short shortVal;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Int_data_type")
	private int id;
	
	@Column(name = "Char_data_type")
	private char chars;
	
	@Column(name = "Boolean_data_type")
	private boolean bool;
	
	@Column(name = "Stirng_data_type")
	private String name;
	
	@Column(name = "Float_data_type")
	private float marks;
	
	@Column(name = "Long_data_type")
	private long age;
	
	@Column(name = "Double_data_type")
	private double salary;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	

	@Temporal(TemporalType.TIME)
	@Column(name = "time")
	private Date time;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TimeStamp")
	private Date dateTime;
	
	public JavaDataTypesModel() {
		
	}

	/**
	 * @param byteVal
	 * @param shortVal
	 * @param chars
	 * @param bool
	 * @param name
	 * @param marks
	 * @param age
	 * @param salary
	 * @param date
	 * @param time
	 * @param dateTime
	 */
	public JavaDataTypesModel(byte byteVal, short shortVal, char chars, boolean bool, String name, float marks,
			long age, double salary, Date date, Date time, Date dateTime) {
		this.byteVal = byteVal;
		this.shortVal = shortVal;
		this.chars = chars;
		this.bool = bool;
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.salary = salary;
		this.date = date;
		this.time = time;
		this.dateTime = dateTime;
	}

	/**
	 * @return the byteVal
	 */
	public byte getByteVal() {
		return byteVal;
	}

	/**
	 * @param byteVal the byteVal to set
	 */
	public void setByteVal(byte byteVal) {
		this.byteVal = byteVal;
	}

	/**
	 * @return the shortVal
	 */
	public short getShortVal() {
		return shortVal;
	}

	/**
	 * @param shortVal the shortVal to set
	 */
	public void setShortVal(short shortVal) {
		this.shortVal = shortVal;
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
	 * @return the chars
	 */
	public char getChars() {
		return chars;
	}

	/**
	 * @param chars the chars to set
	 */
	public void setChars(char chars) {
		this.chars = chars;
	}

	/**
	 * @return the bool
	 */
	public boolean isBool() {
		return bool;
	}

	/**
	 * @param bool the bool to set
	 */
	public void setBool(boolean bool) {
		this.bool = bool;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the marks
	 */
	public float getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(float marks) {
		this.marks = marks;
	}

	/**
	 * @return the age
	 */
	public long getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(long age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaDataTypesModel [byteVal=" + byteVal + ", shortVal=" + shortVal + ", id=" + id + ", chars=" + chars
				+ ", bool=" + bool + ", name=" + name + ", marks=" + marks + ", age=" + age + ", salary=" + salary
				+ ", date=" + date + ", time=" + time + ", dateTime=" + dateTime + "]";
	}
}

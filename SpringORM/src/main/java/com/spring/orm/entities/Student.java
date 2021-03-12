package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@Column(name="student_id")
	private int id;
	
	@Column(name="student_name")
	@Value("priyanka")
	private String name;
	
	@Column(name="student_city")
	private String city;

	/**
	 * @param id
	 * @param name
	 * @param city
	 */
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
	
	

}

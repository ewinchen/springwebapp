package com.estudio.webappv4.domain;

import java.sql.Date;

public class Users {
	
	private int id;
	
	private String name;
	
	private String sex;
	
	private Date birthdate;
	
	private Double weight;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", sex=" + sex + ", birthdate=" + birthdate + ", weight=" + weight
				+ "]";
	}

	

}

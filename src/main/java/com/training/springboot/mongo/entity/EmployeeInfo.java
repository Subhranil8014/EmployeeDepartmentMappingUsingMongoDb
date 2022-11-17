package com.training.springboot.mongo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class EmployeeInfo implements Serializable{
	
	@Id
	//@NotNull(message = "Id shouldn't be null")
	private int id;
	//@NotBlank(message = "Name shouldn't be null")
	private String name;
	private String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeInfo(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public EmployeeInfo() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

}

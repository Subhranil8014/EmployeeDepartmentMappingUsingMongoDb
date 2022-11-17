package com.training.springboot.mongo.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee_Collection")
public class Employeecollection implements Serializable{
	
	@Id
	private int id;
	@NotBlank(message = "Name shouldn't be null")
	private String name;
	@NotBlank(message = "Name shouldn't be null")
	private String deptname;
	@NotBlank(message = "Name shouldn't be null")
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
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employeecollection(int id, String name, String deptname, String email) {
		super();
		this.id = id;
		this.name = name;
		this.deptname = deptname;
		this.email = email;
	}
	
	public Employeecollection() {
		super();
	}
	@Override
	public String toString() {
		return "Employeecollection [id=" + id + ", name=" + name + ", deptname=" + deptname + ", email=" + email + "]";
	}
	
	

}

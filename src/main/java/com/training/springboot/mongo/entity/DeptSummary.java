package com.training.springboot.mongo.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dept_Summary")
public class DeptSummary implements Serializable{
	
	@Id
	private String deptname;
	
	private List<EmployeeInfo> employee;

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public List<EmployeeInfo> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeInfo> employee) {
		this.employee = employee;
	}

	public DeptSummary(String deptname, List<EmployeeInfo> employee) {
		super();
		this.deptname = deptname;
		this.employee = employee;
	}
	

	public DeptSummary() {
		super();
	}

	@Override
	public String toString() {
		return "DeptSummary [deptname=" + deptname + ", employee=" + employee + "]";
	}
	
	

}

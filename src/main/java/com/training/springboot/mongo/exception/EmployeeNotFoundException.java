package com.training.springboot.mongo.exception;

public class EmployeeNotFoundException extends Exception{
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}

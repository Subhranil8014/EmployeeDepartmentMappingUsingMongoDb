package com.training.springboot.mongo.exception;

public class EmployeeAlreadyExists extends Exception{
	
	public EmployeeAlreadyExists(String message) {
		super(message);
	}

}

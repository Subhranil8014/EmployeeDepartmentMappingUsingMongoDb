package com.training.springboot.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.springboot.mongo.entity.Employeecollection;
import java.lang.String;

public interface EmployeeRepo extends MongoRepository<Employeecollection, Integer>{
	
	public List<Employeecollection> findById(int id);
	public List<Employeecollection> findByDeptname(String deptname);
	
	

}

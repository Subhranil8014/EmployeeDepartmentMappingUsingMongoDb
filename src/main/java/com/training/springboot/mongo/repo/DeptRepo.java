package com.training.springboot.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.springboot.mongo.entity.DeptSummary;

public interface DeptRepo extends MongoRepository<DeptSummary, String>{
	public List<DeptSummary> findByDeptname(String deptname);

}

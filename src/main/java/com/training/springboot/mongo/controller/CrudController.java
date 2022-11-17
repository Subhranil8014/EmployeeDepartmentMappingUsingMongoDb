package com.training.springboot.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.training.springboot.mongo.entity.DeptSummary;
import com.training.springboot.mongo.entity.Employeecollection;
import com.training.springboot.mongo.exception.EmployeeAlreadyExists;
import com.training.springboot.mongo.exception.EmployeeNotFoundException;
import com.training.springboot.mongo.repooperations.CrudOperations;

@EnableWebMvc
@CrossOrigin
@RestController
@RequestMapping("/emp")
public class CrudController {
	
	@Autowired
	private CrudOperations crud;
	
	@PostMapping
	public String saveEmployee(@RequestBody @Valid Employeecollection employee) throws EmployeeAlreadyExists {
		return crud.saveEmployee(employee);
	}
	@GetMapping
	public List<Employeecollection> getEmployees(){
		return crud.getAllEmployee();
	}
	@GetMapping("/{deptname}")
	public List<DeptSummary>findByDeptname(@PathVariable String deptname) throws EmployeeNotFoundException{
		return crud.findByDeptname(deptname);
	}
	@PutMapping
	public String updateEmployee(@RequestBody Employeecollection employee) throws EmployeeNotFoundException {
		return crud.updateEmployee(employee);
	}
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
		return crud.deleteEmployee(id);
	}

}

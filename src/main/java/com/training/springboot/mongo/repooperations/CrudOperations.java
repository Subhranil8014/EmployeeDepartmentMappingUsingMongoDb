package com.training.springboot.mongo.repooperations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.mongo.entity.DeptSummary;
import com.training.springboot.mongo.entity.EmployeeInfo;
import com.training.springboot.mongo.entity.Employeecollection;
import com.training.springboot.mongo.exception.EmployeeAlreadyExists;
import com.training.springboot.mongo.exception.EmployeeNotFoundException;
import com.training.springboot.mongo.repo.DeptRepo;
import com.training.springboot.mongo.repo.EmployeeRepo;

@Service
public class CrudOperations {

	@Autowired
	DeptRepo deptRepo;
	@Autowired
	EmployeeRepo empRepo;

	public String saveEmployee(Employeecollection employee) throws EmployeeAlreadyExists {
		if(empRepo.findById(employee.getId())==null) {
			empRepo.save(employee);
			EmployeeInfo employeeInfo=new EmployeeInfo(employee.getId(), employee.getName(), employee.getEmail());
			List<DeptSummary> list=deptRepo.findByDeptname(employee.getDeptname());
			if(list.isEmpty()){
				List<EmployeeInfo> employees=new ArrayList<>();
				employees.add(employeeInfo);
				DeptSummary deptSummary=new DeptSummary(employee.getDeptname(), employees);
				deptRepo.save(deptSummary);
			}
			else if((list.get(0).getDeptname()).equalsIgnoreCase(employee.getDeptname())){
				list.get(0).getEmployee().add(employeeInfo);
				deptRepo.saveAll(list);
			}
			return "data saved";
		}		
		throw new EmployeeAlreadyExists("Regret!Employee already exists!");
		//return "REGRET!";
	}
	public List<Employeecollection>getAllEmployee(){
		return empRepo.findAll();
	}
	public List<DeptSummary> findByDeptname(String deptname) throws EmployeeNotFoundException{
		if(empRepo.findByDeptname(deptname).isEmpty())
			throw new EmployeeNotFoundException("Department doesn't exist!!");
		return deptRepo.findByDeptname(deptname);
	}

	public String updateEmployee(Employeecollection employee) throws EmployeeNotFoundException {
		if(empRepo.findById(employee.getId())==null) {
			throw new EmployeeNotFoundException("Employee doesn't exist!!");
			//return "regret!!!";
		}
		else {
			EmployeeInfo employeeInfo=new EmployeeInfo(employee.getId(), employee.getName(), employee.getEmail());
			List<DeptSummary> list=deptRepo.findByDeptname(employee.getDeptname());
			System.out.println(list+"hi");
			System.out.println(list.get(0)+"hello");
			System.out.println(list.get(0).getEmployee()+"hey");
			if(list.isEmpty()) {
				int i=0;
				List<DeptSummary> listt=deptRepo.findByDeptname(empRepo.findById(employee.getId()).get(0).getDeptname());
				for(EmployeeInfo e:listt.get(0).getEmployee()) {
					if(e.getId()==employee.getId()) {
						i=listt.get(0).getEmployee().indexOf(e);
						
						break;	
					}	
				}
				listt.get(0).getEmployee().remove(i);
				empRepo.save(employee);
				deptRepo.saveAll(listt);
				List<EmployeeInfo> employees=new ArrayList<>();
				employees.add(employeeInfo);
				DeptSummary deptSummary=new DeptSummary(employee.getDeptname(), employees);
				deptRepo.save(deptSummary);	
				return "updated!";
			}
			if(empRepo.findById(employee.getId()).get(0).getDeptname().equalsIgnoreCase(employee.getDeptname())){
				empRepo.save(employee);
				for(EmployeeInfo e:list.get(0).getEmployee()) {
					//System.out.println(list.get(0));
					if(e.getId()==employee.getId()) {
						e.setName(employee.getName());
						e.setEmail(employee.getEmail());
						break;
					}
				}
				deptRepo.saveAll(list);
				return "updated";
			}
			else {
				int i=0;
				for(EmployeeInfo e:list.get(0).getEmployee()) {
					if(e.getId()==employee.getId()) {
						i=list.get(0).getEmployee().indexOf(e);
						break;	
					}	
				}
				list.get(0).getEmployee().remove(i);
				empRepo.save(employee);
				for(EmployeeInfo e:list.get(0).getEmployee()) {
					if(e.getId()==employee.getId()) {
						e.setName(employee.getName());
						e.setEmail(employee.getEmail());
						break;
					}
				}
				deptRepo.saveAll(list);
				return "updated";	
			}

		}

	}
	
	public String deleteEmployee(int id) throws EmployeeNotFoundException {
		if(empRepo.findById(id)==null) {
			throw new EmployeeNotFoundException("Employee doesn't exist!!");
			//return "regret!!!";
		}	
		int i=0;
		List<DeptSummary> list=deptRepo.findByDeptname(empRepo.findById(id).get(0).getDeptname());
		for(EmployeeInfo e:list.get(0).getEmployee()) {
			if(e.getId()==id) {
				i=list.get(0).getEmployee().indexOf(e);
				
				break;	
			}	
		}
		list.get(0).getEmployee().remove(i);
		deptRepo.saveAll(list);
		empRepo.deleteById(id);
		return "deleted";
	}
}

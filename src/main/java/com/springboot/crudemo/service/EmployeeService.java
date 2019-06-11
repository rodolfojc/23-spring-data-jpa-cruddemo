package com.springboot.crudemo.service;

import java.util.List;

import com.springboot.crudemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);
	
}

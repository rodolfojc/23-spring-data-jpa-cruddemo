package com.springboot.crudemo.dao;

import java.util.List;

import com.springboot.crudemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int theId);
	
}

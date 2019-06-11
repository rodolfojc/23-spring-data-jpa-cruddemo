package com.springboot.crudemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crudemo.dao.EmployeeDAO;
import com.springboot.crudemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	//CONSTRUCTOR INJECTION
	@Autowired
	public EmployeeServiceImpl (@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void addEmployee(Employee theEmployee) {
		this.employeeDAO.addEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int theId) {
		this.employeeDAO.deleteEmployeeById(theId);
	}
	

}

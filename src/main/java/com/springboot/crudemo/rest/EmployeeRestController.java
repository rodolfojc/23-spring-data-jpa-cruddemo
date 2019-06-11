package com.springboot.crudemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crudemo.entity.Employee;
import com.springboot.crudemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController (EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// EXPOSE "/EMPLOYESS" -> RETURN ALL EMPLOYESS
	@GetMapping("/employees")
	public List<Employee> findAll () {
		return employeeService.findAll();
	}
	
	// ADD MAPPING FOR GET "/EMPLOYEES/{EMPLOYEEID}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = this.employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee not found - "+employeeId);
		}
		
		return theEmployee;
		
	}
	
	// ADD MAPPING FOR POST /EMPLOYESS - ADD NEW EMPLOYEE
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// ALSO JST IN CASE THEY PASS AND ID JASON - SET TO ID 0
		theEmployee.setId(0);
		this.employeeService.addEmployee(theEmployee);
		
		return theEmployee;
	}
	
	// ADD MAPPING FOR PUT /EMPLOYESS - UPDATE EXISTING EMPLOYEE
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
			
		this.employeeService.addEmployee(theEmployee);
			
		return theEmployee;
	}
	
	// ADD MAPPING FOR DELETE /EMPLOYESS - DELETE EXISTING EMPLOYEE
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = this.employeeService.findById(employeeId);
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee not found - "+employeeId);
		}
		
		this.employeeService.deleteEmployeeById(employeeId);
				
		return "Employee ID " + employeeId + " have been deleted";
	}
	
	
}

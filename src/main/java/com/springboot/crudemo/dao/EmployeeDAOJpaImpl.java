package com.springboot.crudemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.crudemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// CREATE A QUERY
		Query theQuery = this.entityManager.createQuery("from Employee");
		
		// EXECUTE QUERY AND GET RESULT LIST
		List<Employee> employees = theQuery.getResultList();
		
		//RETURN THE RESULT
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//GET EMPLOYEE
		Employee theEmployee = this.entityManager.find(Employee.class, theId);
		
		//RETURN THE EMPLOYEE
		return theEmployee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		
		//SAVE OR UPDATE THE EMPLOYEE
		Employee dbEmployee = this.entityManager.merge(theEmployee);
		
		//UPDATE WITH ID
		theEmployee.setId(dbEmployee.getId());
		
	}

	@Override
	public void deleteEmployeeById(int theId) {
		
		//DELETE OBJECT WITH PRIMARY KEY
		Query theQuery = this.entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}

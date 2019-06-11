package com.springboot.crudemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crudemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

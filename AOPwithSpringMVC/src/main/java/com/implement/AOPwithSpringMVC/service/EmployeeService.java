package com.implement.AOPwithSpringMVC.service;

import java.util.List;

import com.implement.AOPwithSpringMVC.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int employeeId);

	Employee addUpdateEmployee(Employee theEmployee);

	void deleteById(int employeeId);

}

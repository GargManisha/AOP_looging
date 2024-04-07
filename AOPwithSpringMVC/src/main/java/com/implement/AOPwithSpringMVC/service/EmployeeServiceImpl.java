package com.implement.AOPwithSpringMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.implement.AOPwithSpringMVC.dao.EmployeeRepository;
import com.implement.AOPwithSpringMVC.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		employeeRepository = empRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		Employee emp = null;
		if(result.isPresent()) {
			emp = result.get();
		}else {
			throw new RuntimeException("Did not find employee id - " + employeeId);
		}
		return emp;
	}

	@Override
	public Employee addUpdateEmployee(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}

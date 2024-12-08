package eaut.it.javatech.employeeManagement.service;

import org.springframework.stereotype.Service;

import eaut.it.javatech.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
}

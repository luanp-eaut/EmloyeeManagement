package eaut.it.javatech.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import eaut.it.javatech.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<EmployeeModel> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}
	
	public void addEmployee(EmployeeModel employee) {
		employeeRepository.addEmployee(employee);
	}
	
	public EmployeeModel getEmployeeById(Integer employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public void updateEmployee(EmployeeModel employee) {
		employeeRepository.save(employee);

	}
}

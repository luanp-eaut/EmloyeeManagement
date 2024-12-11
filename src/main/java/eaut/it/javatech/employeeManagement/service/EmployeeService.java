package eaut.it.javatech.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import eaut.it.javatech.employeeManagement.repository.EmployeeRepository;
import entity.Employee;
import mapper.EmployeeMapper;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<EmployeeModel> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeModel> employeeModels = employees.stream().map(EmployeeMapper::mapToEmployeeModel).toList();
		return employeeModels;
	}

	public void createEmployee(EmployeeModel employeeModel) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeModel);
		employeeRepository.save(employee);
	}

	public EmployeeModel getEmployeeById(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		return EmployeeMapper.mapToEmployeeModel(employee);
	}

	public void updateEmployee(EmployeeModel employeeModel) {
		employeeRepository.save(EmployeeMapper.mapToEmployee(employeeModel));

	}

	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
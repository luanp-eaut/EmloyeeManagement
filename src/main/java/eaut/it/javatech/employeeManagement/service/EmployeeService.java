package eaut.it.javatech.employeeManagement.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import eaut.it.javatech.employeeManagement.entity.Employee;
import eaut.it.javatech.employeeManagement.mapper.EmployeeMapper;
import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import eaut.it.javatech.employeeManagement.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	private PasswordEncoder passwordEncoder;

	public List<EmployeeModel> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeModel> employeeModels = employees.stream().map(EmployeeMapper::mapToEmployeeModel).toList();
		return employeeModels;
	}

	public void createEmployee(EmployeeModel employeeModel) {
		employeeRepository.save(getEncodedPasswordEmployee(employeeModel));
	}

	public EmployeeModel getEmployeeById(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		return EmployeeMapper.mapToEmployeeModel(employee);
	}

	public EmployeeModel getEmployeeByEmail(String email) {
		Employee employee = employeeRepository.findByEmail(email);
		return EmployeeMapper.mapToEmployeeModel(employee);
	}

	public void updateEmployee(EmployeeModel employeeModel) {
		employeeRepository.save(getEncodedPasswordEmployee(employeeModel));
	}

	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	public Boolean isTelephoneOccupied(String telephone) {
		return employeeRepository.existsByTelephone(telephone);
	}

	public Boolean isEmailOccupied(String email) {
		return employeeRepository.existsByEmail(email);
	}
	
	private Employee getEncodedPasswordEmployee(EmployeeModel employeeModel) {
		String encodedPassword = passwordEncoder.encode(employeeModel.getPassword());
		employeeModel.setPassword(encodedPassword);
		return EmployeeMapper.mapToEmployee(employeeModel);
	}
}
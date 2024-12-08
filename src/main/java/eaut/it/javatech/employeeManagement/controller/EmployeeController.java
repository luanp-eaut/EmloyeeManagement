package eaut.it.javatech.employeeManagement.controller;

import org.springframework.stereotype.Controller;

import eaut.it.javatech.employeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}

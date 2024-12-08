package eaut.it.javatech.employeeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import eaut.it.javatech.employeeManagement.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<EmployeeModel> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employees";
	}
}

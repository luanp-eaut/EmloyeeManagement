package eaut.it.javatech.employeeManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/employees/new")
	public String newEmployee(Model model) {
		EmployeeModel employee = new EmployeeModel();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee, Model model) {
		employeeService.addEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{employeeId}/edit")
	public String editEmployee(@PathVariable("employeeId") Integer employeeId, Model model) {
		EmployeeModel employee = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return "edit_employee";
	}

	@PostMapping("/employees/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") Integer employeeId, EmployeeModel employee, Model model) {
		employee.setId(employeeId);
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{employeeId}/delete")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{employeeId}/view")
	public String viewEmployee(@PathVariable("employeeId") Integer employeeId, Model model) {
		EmployeeModel employee = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return "view_employee";
	}
}

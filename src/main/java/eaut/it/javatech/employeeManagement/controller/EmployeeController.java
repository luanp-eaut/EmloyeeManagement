package eaut.it.javatech.employeeManagement.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import eaut.it.javatech.employeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class EmployeeController {
//	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		List<EmployeeModel> employeeModels = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeModels);
		return "employees";
	}

	@GetMapping("/employees/new")
	public String newEmployee(Model model) {
		EmployeeModel employeeModel = new EmployeeModel();
		model.addAttribute("employee", employeeModel);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeModel employeeModel, BindingResult result,
			Model model) {
		checkConflict(employeeModel, result);

		if (result.hasErrors()) {
			model.addAttribute("employee", employeeModel);
			return "create_employee";
		}
		employeeService.createEmployee(employeeModel);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{employeeId}/edit")
	public String editEmployee(@PathVariable("employeeId") Integer employeeId, Model model) {
		EmployeeModel employee = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return "edit_employee";
	}

	@PostMapping("/employees/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") Integer employeeId,
			@Valid @ModelAttribute("employee") EmployeeModel employeeModel, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("employee", employeeModel);
			return "edit_employee";
		}
		employeeModel.setId(employeeId);
		employeeService.updateEmployee(employeeModel);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{employeeId}/delete")
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{employeeId}/view")
	public String viewEmployee(@PathVariable("employeeId") Integer employeeId, Model model) {
		EmployeeModel employeeModel = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employeeModel);
		return "view_employee";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/disallowed")
	public String disallowed() {
		return "disallowed";
	}

	private void checkConflict(EmployeeModel employee, BindingResult result) {
		if (employeeService.isEmailOccupied(employee.getEmail())) {
			result.rejectValue("email", null, "Email đã được sử dụng");
		}
		if (employeeService.isTelephoneOccupied(employee.getTelephone())) {
			result.rejectValue("telephone", null, "Số điện thoại đã được sử dụng");
		}
	}
}

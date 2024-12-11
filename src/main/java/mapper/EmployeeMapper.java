package mapper;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;
import entity.Employee;

public class EmployeeMapper {
	public static EmployeeModel mapToEmployeeModel(Employee employee) {
		return new EmployeeModel(employee.getId(), employee.getFullName(), employee.getTitle(), employee.getEmail(),
				employee.getTelephone());
	}
	
	public static Employee mapToEmployee(EmployeeModel employeeModel) {
		return new Employee(employeeModel.getId(), employeeModel.getFullName(), employeeModel.getTitle(), employeeModel.getEmail(),
				employeeModel.getTelephone());
	}
}

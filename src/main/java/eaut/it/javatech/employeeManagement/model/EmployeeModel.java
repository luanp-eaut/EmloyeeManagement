package eaut.it.javatech.employeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	private Long id;
	private String fullName;
	private String title;
	private String email;
	private String telephone;
}

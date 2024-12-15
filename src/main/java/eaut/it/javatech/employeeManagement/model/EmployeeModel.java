package eaut.it.javatech.employeeManagement.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	private Integer id;
	@NotEmpty(message = "Hãy nhập họ tên nhân viên")
	private String fullName;
	@NotEmpty(message = "Hãy nhập chức danh nhân viên")
	private String title;
	@NotEmpty(message = "Hãy nhập email nhân viên")
	private String email;
	@NotEmpty(message = "Hãy nhập điện thoại nhân viên")
	private String telephone;
	@NotEmpty(message = "Hãy nhập mật khẩu cho nhân viên")
	private String password;
	@NotEmpty(message = "Hãy chọn phân quyền cho nhân viên")
	private String role;
}

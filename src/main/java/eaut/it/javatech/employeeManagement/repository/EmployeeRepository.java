package eaut.it.javatech.employeeManagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;

@Repository
public class EmployeeRepository {
	private List<EmployeeModel> employees = new ArrayList<EmployeeModel>();

	public EmployeeRepository() {
		employees.add(new EmployeeModel(1, "Nguyễn Văn An", "Giám đốc", "nvan@gmail.com", "0927624356"));
		employees.add(new EmployeeModel(1, "Đặng Hoàng Yến", "Kế toán trưởng", "dhyen@hotmail.com", "0987825751"));
		employees.add(new EmployeeModel(1, "Phan Đăng Toàn", "Lái xe", "pdtoan@gmail.com", "0337244781"));
		employees.add(new EmployeeModel(1, "Trương Thị Huệ", "TP hành chính", "tthue@yahoo.com", "0903428316"));
		employees.add(new EmployeeModel(1, "Trần Quang Tuấn", "Nhân viên", "tqtuan@hotmail.com", "0393844162"));
	}

	public List<EmployeeModel> getAllEmployees() {
		return employees;
	}
}

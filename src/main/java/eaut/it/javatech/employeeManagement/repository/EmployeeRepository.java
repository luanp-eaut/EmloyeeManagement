package eaut.it.javatech.employeeManagement.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import eaut.it.javatech.employeeManagement.model.EmployeeModel;

@Repository
public class EmployeeRepository {
	private List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
	private Integer lastId;

	public EmployeeRepository() {
		employees.add(new EmployeeModel(1, "Nguyễn Văn An", "Giám đốc", "nvan@gmail.com", "0927624356"));
		employees.add(new EmployeeModel(2, "Đặng Hoàng Yến", "Kế toán trưởng", "dhyen@hotmail.com", "0987825751"));
		employees.add(new EmployeeModel(3, "Phan Đăng Toàn", "Lái xe", "pdtoan@gmail.com", "0337244781"));
		employees.add(new EmployeeModel(4, "Trương Thị Huệ", "TP hành chính", "tthue@yahoo.com", "0903428316"));
		employees.add(new EmployeeModel(5, "Trần Quang Tuấn", "Nhân viên", "tqtuan@hotmail.com", "0393844162"));
		lastId = 5;
	}

	public List<EmployeeModel> getAllEmployees() {
		return employees;
	}

	public void addEmployee(EmployeeModel employee) {
		lastId+=1;
		employee.setId(lastId);
		employees.add(employee);
	}

	public EmployeeModel findById(Integer employeeId) {
		return employees.stream().filter(e -> e.getId() == employeeId).findAny().orElse(null);
	}

	public void save(EmployeeModel employee) {
		for (EmployeeModel empl : employees) {
            if (empl.getId() == employee.getId()) {
                empl.setFullName(employee.getFullName()); 
                empl.setTitle(employee.getTitle()); 
                empl.setEmail(employee.getEmail()); 
                empl.setTelephone(employee.getTelephone()); 
                break; 
            }
        }
	}

	public void deleteById(Integer employeeId) {
		EmployeeModel empl = findById(employeeId);
		employees.remove(empl);
	}
}

package eaut.it.javatech.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import eaut.it.javatech.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmail(String email);

	Employee findByTelephone(String telephone);

	@Query("SELECT COUNT(u) > 0 FROM Employee u WHERE u.email = :email")
	boolean existsByEmail(@Param("email") String email);
	
	@Query("SELECT COUNT(u) > 0 FROM Employee u WHERE u.telephone = :telephone")
	boolean existsByTelephone(@Param("telephone") String telephone);
}

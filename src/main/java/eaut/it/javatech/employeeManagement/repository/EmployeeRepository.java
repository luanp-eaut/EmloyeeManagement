package eaut.it.javatech.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}


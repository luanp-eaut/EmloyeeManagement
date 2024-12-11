package eaut.it.javatech.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eaut.it.javatech.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}


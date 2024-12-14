package eaut.it.javatech.employeeManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(nullable = false)
	private String fullName;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false,unique = true)
	private String telephone;
	@Column(nullable = false)
	private String role;
}

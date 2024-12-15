package eaut.it.javatech.employeeManagement.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eaut.it.javatech.employeeManagement.entity.Employee;
import eaut.it.javatech.employeeManagement.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeDetailsService implements UserDetailsService {
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Employee employee = employeeRepository.findByEmail(email);
		if (employee != null) {
			Collection<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(employee.getRole()));
			return new User(employee.getEmail(), employee.getPassword(), roles);
		} else {
			throw new UsernameNotFoundException("Invalid email or password");
		}
	}
}

package com.gongzone.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gongzone.dto.AuthEmployeeDto;
import com.gongzone.entity.Employee;
import com.gongzone.security.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmployeeDetailsService implements UserDetailsService {
	
	private final EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("EmployeeDetailService loadEmployeeByUsername" + username);
		
		Optional<Employee> result = employeeRepository.findEmployeeByEmail(username);
		
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("해당 유저 없음");
		}
		
		Employee employee = result.get();
		
		log.info("----------------------");
		log.info(employee);
		
		AuthEmployeeDto authEmployee = new AuthEmployeeDto(
				employee.getEmployeeEmail(),
				employee.getEmployeePassword(),
				employee.getRoleSet().stream()
				.map(role -> new SimpleGrantedAuthority(role.name()))
				.collect(Collectors.toSet()));
		
		authEmployee.setEmployeeName(employee.getEmployeeName());
		
		return authEmployee;
	}

}

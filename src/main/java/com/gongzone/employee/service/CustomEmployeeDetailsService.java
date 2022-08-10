package com.gongzone.employee.service;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomEmployeeDetailsService implements UserDetailsService {

	private final EmployeeRepository employeeRepository;
	
	// 사원 존재 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return employeeRepository.findByEmployeeEmail(username)
				.map(this::createUserDetails)
				.orElseThrow(() -> new UsernameNotFoundException(username + "를 찾을 수 없습니다."));
				
	}
	
	private UserDetails createUserDetails(Employee employee) {
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(employee.getEmployeeRole().toString());
		
		return new User(
				String.valueOf(employee.getEmployeeId()),
				employee.getEmployeePassword(),
				Collections.singleton(grantedAuthority)
				);
	}

}

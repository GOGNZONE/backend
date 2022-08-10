package com.gongzone.security.service;

import javax.transaction.Transactional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gongzone.employee.dto.TokenDto;
import com.gongzone.employee.dto.request.EmployeeRequestDto;
import com.gongzone.employee.dto.response.EmployeeResponseDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.repository.EmployeeRepository;
import com.gongzone.security.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

	private final AuthenticationManagerBuilder managerBuilder;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	
	public EmployeeResponseDto signUp(EmployeeRequestDto requestDto) {
		if(employeeRepository.existsByEmployeeEmail(requestDto.getEmployeeEmail())) {
			throw new RuntimeException("이미 존재하는 이메일 입니다.");
		}
		
//		if(employeeRepository.existsByEmployeeId(requestDto.getEmployeeId())) {
//			throw new RuntimeException("이미 존재하는 사번 입니다.");
//		}
		
		Employee employee = requestDto.toEmployee(passwordEncoder);
		
		return EmployeeResponseDto.of(employeeRepository.save(employee));
	}
	
	public TokenDto login(EmployeeRequestDto requestDto) {
		UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
		
		Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
		
		return tokenProvider.generateTokenDto(authentication);
	}
}

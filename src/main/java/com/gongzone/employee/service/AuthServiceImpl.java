package com.gongzone.employee.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.TokenDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.repository.EmployeeRepository;
import com.gongzone.security.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;

/**
 * Employee Auth Service
 * @author kimmingyu
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {
	
	private final AuthenticationManagerBuilder managerBuilder;
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;
	private final TokenProvider tokenProvider;
	
	/**
	 * 사원 생성(회원가입)
	 * @throws RuntimeException
	 * @param EmployeeRequestDto
	 * @return EmployeeResponseDto
	 * */
	@Override
	public EmployeeResponseDto registerEmployee(EmployeeRequestDto requestDto) {
		if (employeeRepository.existsByEmployeeEmail(requestDto.getEmployeeEmail())) {
			throw new RuntimeException("이미 존재하는 사원입니다.");
		}
		
		Employee employee = requestDto.toEmployee(passwordEncoder);
		return EmployeeResponseDto.of(employeeRepository.save(employee));
	}

	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	@Override
	public TokenDto login(EmployeeRequestDto requestDto) {
		UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
		
		Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
		
		return tokenProvider.generateTokenDto(authentication);
	}

}

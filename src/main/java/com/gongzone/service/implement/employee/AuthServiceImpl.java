package com.gongzone.service.implement.employee;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeRequest;
import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeResponse;
import com.gongzone.dto.employee.TokenDto;
import com.gongzone.entity.employee.Employee;
import com.gongzone.repository.employee.EmployeeRepository;
import com.gongzone.security.jwt.TokenProvider;
import com.gongzone.service.employee.AuthService;

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
	 * 계정 생성
	 * @throws RuntimeException
	 * @param AuthEmployeeRequest
	 * @return EmployeeResponseDto
	 * */
	@Override
	public AuthEmployeeResponse registerEmployee(AuthEmployeeRequest requestDto) {
		if (employeeRepository.existsByEmployeeEmail(requestDto.getEmployeeEmail())) {
			throw new RuntimeException("이미 존재하는 사원입니다.");
		}
		
		Employee employee = requestDto.toEntity(passwordEncoder);
		return AuthEmployeeResponse.of(employeeRepository.save(employee));
	}

	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	@Override
	public TokenDto login(AuthEmployeeRequest requestDto) {
		UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
		Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
		
		return tokenProvider.generateTokenDto(authentication);
	}

}

package com.gongzone.service.employee;

import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeRequest;
import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeResponse;
import com.gongzone.dto.employee.TokenDto;

/**
 * Employee Auth Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface AuthService {

	/**
	 * 사원 생성(회원가입)
	 * @throws RuntimeException
	 * @param EmployeeRequestDto
	 * @return EmployeeResponseDto
	 * */
	public AuthEmployeeResponse registerEmployee(AuthEmployeeRequest requestDto);
	
	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	public TokenDto login(AuthEmployeeRequest requestDto);
		
	
}

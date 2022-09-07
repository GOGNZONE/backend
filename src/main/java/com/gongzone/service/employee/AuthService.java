package com.gongzone.service.employee;

import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.TokenDto;

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
	public EmployeeResponseDto registerEmployee(EmployeeRequestDto requestDto);
	
	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	public TokenDto login(EmployeeRequestDto requestDto);
		
	
}

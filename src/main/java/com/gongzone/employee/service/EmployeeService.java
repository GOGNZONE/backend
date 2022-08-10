package com.gongzone.employee.service;

import java.util.List;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.UpdateEmployeeDto;

/**
 * Employee Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface EmployeeService {
	
	/**
	 * 전체 사원 조회
	 * @return List<EmployeeListResponseDto>
	 * */
	public List<EmployeeListDto> findAllEmployee();
	
	/**
	 * 특정 사원 조회
	 * @param { employeeId }
	 * @return EmployeeInfoDto
	 * @throws IllegalAccessException 
	 * */
	public EmployeeDto findByEmployeeId(Long employeeId) throws IllegalAccessException;
	
	/**
	 * 사원 수정
	 * @param { employeeInfoDto }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void updateEmployee(Long employeeId,UpdateEmployeeDto updateDto) throws IllegalAccessException;
	
	/**
	 * 특정 사원 삭제
	 * @param { employeeId }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void deleteEmployee(Long employeeId) throws IllegalAccessException;
	
	/**
	 * 마이페이지
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	public EmployeeResponseDto getMyInfoBySecurity();
	
	/**
	 * 비밀번호 변경
	 * @param { employeeEmail, exPassword, newPassword }
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	public EmployeeResponseDto changeEmployeePassword(String employeeEmail, String exPassword, String newPassword);
}

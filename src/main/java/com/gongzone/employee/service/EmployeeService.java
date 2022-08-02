package com.gongzone.employee.service;

import java.util.List;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
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
	 * */
	public EmployeeDto findByEmployeeId(Long employeeId);
	
	/**
	 * 사원 수정
	 * @param { employeeInfoDto }
	 * @return void
	 * */
	public void updateEmployee(Long employeeId,UpdateEmployeeDto updateDto);
	
	/**
	 * 특정 사원 삭제
	 * @param { employeeId }
	 * @return void
	 * */
	public void deleteEmployee(Long employeeId);
}

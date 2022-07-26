package com.gongzone.service.employee;

import java.util.List;

import com.gongzone.dto.employee.RetiredEmployeeDto.RetiredEmployeeResponse;

public interface RetiredEmployeeService {

	/**
	 * 전체 퇴사자 조회
	 * @return List<RetiredEmployeeDto>
	 * */
	public List<RetiredEmployeeResponse> findAllRetiredEmployee();

	/**
	 * 퇴사자 상세 조회
	 * @return RetiredEmployeeDto
	 * @throws IllegalAccessException 
	 * */
	public RetiredEmployeeResponse findByRetiredEmployeeId(Long retiredEmployeeId) throws IllegalAccessException;
	
	
	/**
	 * 퇴사자 삭제
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void deleteRetiredEmployee(Long retiredEmployeeId) throws IllegalAccessException;
}

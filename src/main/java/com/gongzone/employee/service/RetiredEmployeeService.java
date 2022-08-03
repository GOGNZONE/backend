package com.gongzone.employee.service;

import java.util.List;

import com.gongzone.employee.dto.RetiredEmployeeDto;

public interface RetiredEmployeeService {

	/**
	 * 전체 퇴사자 조회
	 * @return List<RetiredEmployeeDto>
	 * */
	public List<RetiredEmployeeDto> findAllRetiredEmployee();

	/**
	 * 퇴사자 상세 조회
	 * @return RetiredEmployeeDto
	 * */
	public RetiredEmployeeDto findByRetiredEmployeeId(Long retiredEmployeeId);
	
	
	/**
	 * 퇴사자 삭제
	 * @return List<RetiredEmployeeDto> 
	 * */
	public void deleteRetiredEmployee(Long retiredEmployeeId);
}

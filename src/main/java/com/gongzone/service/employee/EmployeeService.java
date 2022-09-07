package com.gongzone.service.employee;

import java.util.List;

import com.gongzone.dto.employee.ChangeMyProfile;
import com.gongzone.dto.employee.EmployeeInfoDto.EmployeeInfoResponse;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.exception.ResourceNotFoundException;

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
	 * @throws ResourceNotFoundException 
	 * */
	public EmployeeInfoResponse findByEmployeeId(Long employeeId) throws IllegalAccessException, ResourceNotFoundException;
	
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
	 * 마이페이지 수정
	 * @param { employeeEmail, exPassword, newPassword, employeeName, employeePhone, employeeAddress, employeeImage } ChangeMyProfile
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	public EmployeeResponseDto changeEmployeeProfile(ChangeMyProfile changeMyProfile);
}

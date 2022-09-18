package com.gongzone.service.employee;

import java.util.List;

import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeResponse;
import com.gongzone.dto.employee.ChangeMyProfile;
import com.gongzone.dto.employee.EmployeeListDto.EmployeeListResponse;
import com.gongzone.dto.employee.EmployeeInfoDto.EmployeeInfoResponse;

/**
 * Employee Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface EmployeeService {
	
	/**
	 * 전체 사원 조회
	 * @return List<EmployeeListResponse>
	 * */
	public List<EmployeeListResponse> findAllEmployee();
	
	/**
	 * 특정 사원 조회
	 * @param { employeeId }
	 * @return EmployeeInfoDto
	 * @throws IllegalAccessException 
	 * @throws ResourceNotFoundException 
	 * */
	public EmployeeInfoResponse findByEmployeeId(Long employeeId) throws IllegalAccessException;
	
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
	public AuthEmployeeResponse getMyInfoBySecurity();
	
	/**
	 * 마이페이지 수정
	 * @param { employeeEmail, exPassword, newPassword, employeeName, employeePhone, employeeAddress, employeeImage } ChangeMyProfile
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	public void changeEmployeeProfile(ChangeMyProfile changeMyProfile);
	
	/**
	 * 비밀번호 수정
	 * @param { newPassword } ChangeMyProfile
	 * */
	public void changePassword(ChangeMyProfile changeMyProfile);
	
}

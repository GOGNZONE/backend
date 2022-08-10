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
import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gongzone.config.SecurityUtil;
import com.gongzone.employee.dto.response.EmployeeResponseDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 마이페이지 조회
	 * @throws RuntimeException -> 해당하는 회원 없음
	 * @return EmployeeReponseDto
	 */
	public EmployeeResponseDto getMyInfoBySecurity() {
		return employeeRepository.findById(SecurityUtil.getCurrentMemberId())
				.map(EmployeeResponseDto::of)
				.orElseThrow(() -> new RuntimeException("해당하는 회원이 존재하지 않습니다."));
	}
	
	
	/**
	 * 비밀번호 변경
	 * @throws RuntimeException -> 해당하는 회원 없음
	 * @return Employee
	 */
	@Transactional
	public EmployeeResponseDto changeEmployeePassword(String employeeEmail, String exPassword, String newPassword) {
		Employee employee = employeeRepository.findById(SecurityUtil.getCurrentMemberId())
				.orElseThrow(() -> new RuntimeException("해당하는 회원이 존재하지 않습니다."));
		
		if(!passwordEncoder.matches(exPassword, employee.getEmployeePassword())) {
			throw new RuntimeException("비밀전호가 맞지 않습니다.");
		}
		employee.updateEmployeePassword(passwordEncoder.encode(newPassword));
		return EmployeeResponseDto.of(employeeRepository.save(employee));
	}
}

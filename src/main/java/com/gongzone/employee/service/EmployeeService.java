package com.gongzone.employee.service;

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

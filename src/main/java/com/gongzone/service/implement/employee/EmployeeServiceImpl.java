package com.gongzone.service.implement.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.config.SecurityUtil;
import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeResponse;
import com.gongzone.dto.employee.ChangeMyProfile;
import com.gongzone.dto.employee.EmployeeListDto.EmployeeListResponse;
import com.gongzone.dto.employee.RetiredEmployeeDto.RetiredEmployeeRequest;
import com.gongzone.dto.employee.EmployeeInfoDto.EmployeeInfoResponse;
import com.gongzone.entity.employee.Employee;
import com.gongzone.repository.employee.EmployeeRepository;
import com.gongzone.repository.employee.RetiredEmployeeRepository;
import com.gongzone.service.employee.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RetiredEmployeeRepository retiredEmployeeRepository;
	
	/* Security */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 전체 사원 조회
	 * 
	 * @return List<EmployeeListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeListResponse> findAllEmployee() {
		List<EmployeeListResponse> employees = employeeRepository.findAll()
				.stream()
				.map(EmployeeListResponse::new)
				.collect(Collectors.toList());
		return employees;
//		return employeeListMapper.toDtoList(employees);
	}


	/**
	 * 특정 사원 조회
	 * 
	 * @param { employeeId }
	 * @return EmployeeInfoDto
	 * @throws IllegalAccessException 
	 */
	@Override
	@Transactional(readOnly = true)
	public EmployeeInfoResponse findByEmployeeId(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 사원 없음"));
		return new EmployeeInfoResponse(employee);
	}
	
	/**
	 * 마이페이지
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	@Override
	@Transactional(readOnly = true)
	public AuthEmployeeResponse getMyInfoBySecurity() {
		return employeeRepository.findById(SecurityUtil.getCurrentEmployeeId())
				.map(AuthEmployeeResponse::of)
				.orElseThrow(() -> new RuntimeException("로그인 사원 정보가 없습니다."));
	}

	/**
	 * 마이페이지 수정
	 * @param { employeeEmail, exPassword, newPassword, employeeName, employeePhone, employeeAddress, employeeImage } ChangeMyProfile
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	@Override
	@Transactional
	public AuthEmployeeResponse changeEmployeeProfile(@Valid ChangeMyProfile requestDto) throws RuntimeException {
		Employee employee = employeeRepository.findById(SecurityUtil.getCurrentEmployeeId()).orElseThrow(
				() -> new RuntimeException("로그인 사원 정보가 없습니다."));
		
		
		employee.updateEmployeePassword(passwordEncoder.encode(requestDto.getNewPassword()));
		employee.updateEmployeeInfo(requestDto.toEntity());
		return AuthEmployeeResponse.of(employeeRepository.save(employee));
	}
	
	/**
	 * 특정 사원 삭제
	 * @param { employeeId }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	@Override
	@Transactional
	public void deleteEmployee(Long employeeId) throws IllegalAccessException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new IllegalAccessException("존재하지 않는 사원 입니다."));

		RetiredEmployeeRequest retiredEmployeeDto = new RetiredEmployeeRequest(
				employee.getEmployeeId(),
				employee.getEmployeeName(),
				employee.getEmployeeAddress(),
				employee.getEmployeeEmail(),
				employee.getEmployeePhone(),
				employee.getEmployeeHiredate(),
				LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
				employee.getEmployeeRole(),
				employee.getEmployeeImage());
		
		retiredEmployeeRepository.save(retiredEmployeeDto.toEntity());
		
		employeeRepository.delete(employee);
	}

}

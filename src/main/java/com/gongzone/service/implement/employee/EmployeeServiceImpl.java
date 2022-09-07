package com.gongzone.service.implement.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.config.SecurityUtil;
import com.gongzone.dto.employee.ChangeMyProfile;
import com.gongzone.dto.employee.EmployeeInfoDto.EmployeeInfoResponse;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.mapper.EmployeeListMapper;
import com.gongzone.employee.mapper.RetiredEmployeeMapper;
import com.gongzone.entity.employee.Employee;
import com.gongzone.exception.ResourceNotFoundException;
import com.gongzone.repository.employee.EmployeeRepository;
import com.gongzone.repository.employee.RetiredEmployeeRepository;
import com.gongzone.service.employee.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RetiredEmployeeRepository retiredEmployeeRepository;
	
	/* Mapper */
	private final RetiredEmployeeMapper retiredEmployeeMapper = Mappers.getMapper(RetiredEmployeeMapper.class);
	private final EmployeeListMapper employeeListMapper = Mappers.getMapper(EmployeeListMapper.class);
	
	/* Security */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * 전체 사원 조회
	 * 
	 * @return List<EmployeeListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeListDto> findAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		return employeeListMapper.toDtoList(employees);
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
	public EmployeeInfoResponse findByEmployeeId(Long employeeId) throws ResourceNotFoundException  {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("존재하지 않는 사원입니다."));
		return new EmployeeInfoResponse(employee);
	}
	
	/**
	 * 마이페이지
	 * @return EmployeeResponseDto
	 * @throws RuntimeException 
	 * */
	@Override
	@Transactional(readOnly = true)
	public EmployeeResponseDto getMyInfoBySecurity() {
		return employeeRepository.findById(SecurityUtil.getCurrentEmployeeId())
				.map(EmployeeResponseDto::of)
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
	public EmployeeResponseDto changeEmployeeProfile(@Valid ChangeMyProfile requestDto) throws RuntimeException {
		Employee employee = employeeRepository.findById(SecurityUtil.getCurrentEmployeeId()).orElseThrow(
				() -> new RuntimeException("로그인 사원 정보가 없습니다."));
		
//		if (!passwordEncoder.matches(requestDto.getExPassword(), employee.getEmployeePassword())) {
//			throw new RuntimeException("비밀번호가 맞지 않습니다.");
//		}
		
		employee.updateEmployeePassword(passwordEncoder.encode(requestDto.getNewPassword()));
		employee.updateEmployeeInfo(requestDto.toEntity());
		return EmployeeResponseDto.of(employeeRepository.save(employee));
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
		
		RetiredEmployeeDto retiredEmployeeDto = new RetiredEmployeeDto(
				employee.getEmployeeId(),
				employee.getEmployeeName(),
				employee.getEmployeeAddress(),
				employee.getEmployeeEmail(),
				employee.getEmployeePhone(),
				employee.getEmployeeHiredate(),
				LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")),
				employee.getEmployeeRole(),
				employee.getEmployeeImage());
		
		retiredEmployeeRepository.save(retiredEmployeeMapper.toEntity(retiredEmployeeDto));
		employeeRepository.delete(employee);
	}



	

}

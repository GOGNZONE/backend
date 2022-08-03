package com.gongzone.employee.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.mapper.EmployeeListMapper;
import com.gongzone.employee.mapper.EmployeeMapper;
import com.gongzone.employee.mapper.RetiredEmployeeMapper;
import com.gongzone.employee.mapper.UpdateEmployeeMapper;
import com.gongzone.employee.repository.EmployeeRepository;
import com.gongzone.employee.repository.RetiredEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RetiredEmployeeRepository retiredEmployeeRepository;
	private final RetiredEmployeeMapper retiredEmployeeMapper = Mappers.getMapper(RetiredEmployeeMapper.class);
	private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
	private final EmployeeListMapper employeeListMapper = Mappers.getMapper(EmployeeListMapper.class);
	private final UpdateEmployeeMapper updateEmployeeMapper = Mappers.getMapper(UpdateEmployeeMapper.class);
	
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
	 * @return List<EmployeeListDto>
	 * @throws IllegalAccessException 
	 */
	@Override
	@Transactional(readOnly = true)
	public EmployeeDto findByEmployeeId(Long employeeId) throws IllegalAccessException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new IllegalAccessException("존재하지 않는 사원입니다."));
		return employeeMapper.toDto(employee);
	}

	/**
	 * 사원 정보 수정
	 * 
	 * @param { employeeId, UpdateEmployeeDto }
	 * @return void
	 * @throws IllegalAccessException 
	 */
	@Override
	@Transactional
	public void updateEmployee(Long employeeId, UpdateEmployeeDto updateDto) throws IllegalAccessException {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new IllegalAccessException("존재하지 않는 사원 입니다."));
		
		employee.updateEmployeeInfo(updateEmployeeMapper.toEntity(updateDto));
	}	

	/**
	 * 사원 정보 삭제
	 * 
	 * @param { employeeId }
	 * @return void
	 * @throws IllegalAccessException 
	 */
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

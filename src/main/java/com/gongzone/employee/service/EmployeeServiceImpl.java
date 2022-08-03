package com.gongzone.employee.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.mapper.EmployeeListMapper;
import com.gongzone.employee.mapper.EmployeeMapper;
import com.gongzone.employee.mapper.UpdateEmployeeMapper;
import com.gongzone.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
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
	 */
	@Override
	@Transactional(readOnly = true)
	public EmployeeDto findByEmployeeId(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				null);
		return employeeMapper.toDto(employee);
	}

	/**
	 * 사원 정보 수정
	 * 
	 * @param { employeeId, UpdateEmployeeDto }
	 * @return void
	 */
	@Override
	@Transactional
	public void updateEmployee(Long employeeId, UpdateEmployeeDto updateDto) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(null);
		
		employee.updateEmployeeInfo(updateEmployeeMapper.toEntity(updateDto));
	}	

	/**
	 * 사원 정보 삭제
	 * 
	 * @param { employeeId }
	 * @return void
	 */
	@Override
	@Transactional
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(null);
		
		employeeRepository.delete(employee);
	}

}

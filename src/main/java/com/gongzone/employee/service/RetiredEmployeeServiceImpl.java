package com.gongzone.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.entity.RetiredEmployee;
import com.gongzone.employee.mapper.RetiredEmployeeMapperImpl;
import com.gongzone.employee.repository.RetiredEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetiredEmployeeServiceImpl implements RetiredEmployeeService {
	
	private final RetiredEmployeeRepository retiredEmployeeRepository;
	private final RetiredEmployeeMapperImpl retiredEmployeeMapper;
	
	/**
	 * 전체 퇴사자 조회
	 * 
	 * @return List<RetiredEmployeeDto>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<RetiredEmployeeDto> findAllRetiredEmployee() {
		List<RetiredEmployee> retiredEmployees = retiredEmployeeRepository.findAll();
		return retiredEmployeeMapper.toDtoList(retiredEmployees);
	}

	/**
	 * 퇴사자 삭제
	 * 
	 * @param { retiredEmployeeId }
	 * @return void
	 */
	@Override
	public void deleteRetiredEmployee(Long retiredEmployeeId) {
		RetiredEmployee retiredEmployee = retiredEmployeeRepository.findById(retiredEmployeeId).orElseThrow(null);
		
		retiredEmployeeRepository.delete(retiredEmployee);
	}

	/**
	 * 퇴사자 상세 조회
	 * 
	 * @param { retiredEmployeeId }
	 * @return RetiredEmployeeDto
	 */
	@Override
	public RetiredEmployeeDto findByRetiredEmployeeId(Long retiredEmployeeId) {
		RetiredEmployee retiredEmployee = retiredEmployeeRepository.findById(retiredEmployeeId).orElseThrow();
		
		return retiredEmployeeMapper.toDto(retiredEmployee);
	}

}

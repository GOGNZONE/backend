package com.gongzone.service.implement.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;

import com.gongzone.dto.employee.RetiredEmployeeDto.RetiredEmployeeResponse;
import com.gongzone.entity.employee.RetiredEmployee;
import com.gongzone.repository.employee.RetiredEmployeeRepository;
import com.gongzone.service.employee.RetiredEmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetiredEmployeeServiceImpl implements RetiredEmployeeService {
	
	private final RetiredEmployeeRepository retiredEmployeeRepository;
	
	/**
	 * 전체 퇴사자 조회
	 * 
	 * @return List<RetiredEmployeeDto>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<RetiredEmployeeResponse> findAllRetiredEmployee() {
		List<RetiredEmployeeResponse> retiredEmployees = retiredEmployeeRepository.findAll()
				.stream()
				.map(RetiredEmployeeResponse::new)
				.collect(Collectors.toList());
				
		return retiredEmployees;
	}

	/**
	 * 퇴사자 삭제
	 * 
	 * @param { retiredEmployeeId }
	 * @return void
	 * @throws IllegalAccessException 
	 */
	@Override
	public void deleteRetiredEmployee(Long retiredEmployeeId) {
		RetiredEmployee retiredEmployee = retiredEmployeeRepository.findById(retiredEmployeeId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		retiredEmployeeRepository.delete(retiredEmployee);
	}

	/**
	 * 퇴사자 상세 조회
	 * 
	 * @param { retiredEmployeeId }
	 * @return RetiredEmployeeDto
	 * @throws IllegalAccessException 
	 */
	@Override
	public RetiredEmployeeResponse findByRetiredEmployeeId(Long retiredEmployeeId) {
		RetiredEmployee retiredEmployee = retiredEmployeeRepository.findById(retiredEmployeeId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		return new RetiredEmployeeResponse(retiredEmployee);
	}
}

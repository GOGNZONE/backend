package com.gongzone.employee.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.service.RetiredEmployeeServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/retired-employee")
@RequiredArgsConstructor
public class ApiRetiredEmployeeController {
	
	private final RetiredEmployeeServiceImpl retiredEmployeeService;
	
	/**
	 *  전체 사원 조회
	 *  @return List<EmployeeListDto>
	 */
	@ApiOperation(value = "전체 사원 조회", notes = "전체 사원 조회")
	@GetMapping("/list")
	public ResponseEntity<List<RetiredEmployeeDto>> findAllEmployee() {
		return ResponseEntity.ok(retiredEmployeeService.findAllRetiredEmployee());
	}
	
}

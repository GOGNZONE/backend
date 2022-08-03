package com.gongzone.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.response.EmployeeResponseDto;
import com.gongzone.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@GetMapping("/me")
	public ResponseEntity<EmployeeResponseDto> getMyEmployeeInfo() {
		EmployeeResponseDto myInfoBySecurity = employeeService.getMyInfoBySecurity();
		return ResponseEntity.ok(myInfoBySecurity);
	}
}

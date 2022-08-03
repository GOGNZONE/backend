package com.gongzone.employee.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.service.EmployeeServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class apiController {

	private final EmployeeServiceImpl employeeService;
	
	/**
	 *  전체 사원 조회
	 *  @return List<EmployeeListDto>
	 */
	@GetMapping("/list")
	public ResponseEntity<List<EmployeeListDto>> findAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmployee());
	}
	
	@GetMapping("{employeeId}")
	public ResponseEntity<EmployeeDto> findByEmployeeId(@PathVariable Long employeeId) {
		return ResponseEntity.ok(employeeService.findByEmployeeId(employeeId));
	}
	
	@PutMapping("{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,
			@Validated @RequestBody UpdateEmployeeDto requestDto) {
		try {
			employeeService.updateEmployee(employeeId, requestDto);
			return ResponseEntity.ok("수정 성공");
		} catch (Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return null;
	}
	
	@DeleteMapping("{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
		try {
			employeeService.deleteEmployee(employeeId);
			return ResponseEntity.ok("삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return null;
	}
}

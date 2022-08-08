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

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class ApiEmployeeController {

	private final EmployeeServiceImpl employeeService;
	
	/**
	 *  전체 사원 조회
	 *  @return List<EmployeeListDto>
	 */
	@ApiOperation(value = "전체 사원 조회", notes = "전체 사원 조회")
	@GetMapping("/list")
	public ResponseEntity<List<EmployeeListDto>> findAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmployee());
	}
	
	/**
	 *  특정 사원 조회
	 *  @param employeeId Long
	 *  @return EmployeeDto
	 */
	@ApiOperation(value = "특정 사원 조회", notes = "특정 사원 조회")
	@GetMapping("{employeeId}")
	public ResponseEntity<EmployeeDto> findByRetiredEmployeeId(@PathVariable Long employeeId) {
		try {
			return ResponseEntity.ok(employeeService.findByEmployeeId(employeeId));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			// log 추가
		}
		return null;
	}
	
	/**
	 *  사원 정보 수정
	 *  @param employeeId Long
	 *  @param requestDto UpdateEmployeeDto
	 *  @return success -> "수정 성공"
	 */
	@ApiOperation(value = "사원 정보 수정", notes = "사원 정보 수정")
	@PutMapping("{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,
			@Validated @RequestBody UpdateEmployeeDto requestDto) {
		try {
			employeeService.updateEmployee(employeeId, requestDto);
		} catch (Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return ResponseEntity.ok("수정 성공");
	}
	
	/**
	 *  사원 정보 삭제
	 *  @param employeeId Long
	 *  @return success -> "삭제 성공"
	 */
	@ApiOperation(value = "사원 정보 삭제", notes = "사원 정보 삭제")
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

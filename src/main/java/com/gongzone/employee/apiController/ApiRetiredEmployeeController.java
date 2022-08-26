package com.gongzone.employee.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.service.AuthServiceImpl;
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
	@ApiOperation(value = "전체 퇴사자 조회", notes = "전체 퇴사자 조회")
	@GetMapping("/list")
	public ResponseEntity<List<RetiredEmployeeDto>> findAllEmployee() {
		return ResponseEntity.ok(retiredEmployeeService.findAllRetiredEmployee());
	}
	
	/**
	 * 퇴사자 상세 조회
	 * @return RetiredEmployeeDto
	 * @throws IllegalAccessException 
	 * */
	@ApiOperation(value = "해당 퇴사자 조회", notes = "해당 퇴사자 조회")
	@GetMapping("{retiredEmployeeId}")
	public ResponseEntity<RetiredEmployeeDto> findByRetiredEmployeeId(@PathVariable Long retiredEmployeeId) {
		try {
			return ResponseEntity.ok(retiredEmployeeService.findByRetiredEmployeeId(retiredEmployeeId));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			// log 생성
		}
		return null;
	}
	
	/**
	 * 퇴사자 삭제
	 * @return success -> "삭제 성공"
	 * @throws IllegalAccessException 
	 * */
	@DeleteMapping("{retiredEmployeeId}")
	public ResponseEntity<String> deleteRetiredEmployee(@PathVariable Long retiredEmployeeId) {
		try {
			retiredEmployeeService.deleteRetiredEmployee(retiredEmployeeId);
			return ResponseEntity.ok("삭제 성공");
		} catch(Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return null;
		
	}
}

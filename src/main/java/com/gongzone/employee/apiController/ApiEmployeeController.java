package com.gongzone.employee.apiController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.ChangePasswordRequestDto;
import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.service.AuthServiceImpl;
import com.gongzone.employee.service.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@Tag(name = "employee", description = "사원 관리 API")
public class ApiEmployeeController {

	private final EmployeeServiceImpl employeeService;
	private final AuthServiceImpl authService;

	/**
	 * 사원 생성(회원가입)
	 * 
	 * @throws RuntimeException
	 * @param EmployeeRequestDto
	 * @return EmployeeResponseDto
	 */
	@PostMapping("/register")
	@Operation(summary = "사원 등록", description = "사원 등록")
	public ResponseEntity<EmployeeResponseDto> registerEmployee(@Parameter(
			name = "test",
			in = ParameterIn.PATH,
			description = "test",
			required = true,
			example = "1"
			) @RequestBody EmployeeRequestDto requestDto) {
		return ResponseEntity.ok(authService.registerEmployee(requestDto));
	}

	/**
	 * 전체 사원 조회
	 * 
	 * @return List<EmployeeListDto>
	 */
	@Operation(summary = "get employees", description = "사원 정보 list 가져오기", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeListDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR") })
	@GetMapping("/list")
	public ResponseEntity<List<EmployeeListDto>> findAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmployee());
	}

	/**
	 * 특정 사원 조회
	 * 
	 * @param employeeId Long
	 * @return EmployeeDto
	 */
	@Operation(summary = "test hello", description = "hello api example")
	@GetMapping("{employeeId}")
	public ResponseEntity<EmployeeDto> findByRetiredEmployeeId(
			@Parameter(name = "employee_id", description = "사원 번호", in = ParameterIn.PATH) @PathVariable Long employeeId) {
		EmployeeDto employeeDto = null;
		try {
			employeeDto = employeeService.findByEmployeeId(employeeId);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(employeeDto);
	}

	/**
	 * 사원 정보 수정
	 * 
	 * @param employeeId Long
	 * @param requestDto UpdateEmployeeDto
	 * @return success -> "수정 성공"
	 */
	@PutMapping("{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,
			@Validated @RequestBody final UpdateEmployeeDto requestDto) {
		try {
			employeeService.updateEmployee(employeeId, requestDto);
		} catch (Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return ResponseEntity.ok("수정 성공");
	}

	/**
	 * 사원 정보 삭제
	 * 
	 * @param employeeId Long
	 * @return success -> "삭제 성공"
	 */
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

	/**
	 * 마이페이지
	 * 
	 * @return EmployeeResponseDto
	 * @throws RuntimeException
	 */
	@GetMapping("/mypage")
	public ResponseEntity<EmployeeResponseDto> getMyInfoBySecurity() {
		EmployeeResponseDto employeeResponseDto = employeeService.getMyInfoBySecurity();
		return ResponseEntity.ok(employeeResponseDto);
	}

	/**
	 * 비밀번호 변경
	 * 
	 * @param { employeeEmail, exPassword, newPassword }
	 * @return EmployeeResponseDto
	 * @throws RuntimeException
	 */
	@PostMapping("/password")
	public ResponseEntity<EmployeeResponseDto> changeEmployeePassword(
			@Valid @RequestBody final ChangePasswordRequestDto requestDto) {
		return ResponseEntity.ok(employeeService.changeEmployeePassword(requestDto.getEmployeeEmail(),
				requestDto.getExPassword(), requestDto.getNewPassword()));
	}
}

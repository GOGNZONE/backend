package com.gongzone.apiController.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gongzone.dto.employee.ChangeMyProfile;
import com.gongzone.dto.employee.EmployeeInfoDto;
import com.gongzone.dto.employee.EmployeeInfoDto.EmployeeInfoResponse;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.exception.ResourceNotFoundException;
import com.gongzone.service.implement.employee.AuthServiceImpl;
import com.gongzone.service.implement.employee.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@Tag(name = "EMPLOYEE", description = "사원 관리 API")
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
	@Operation(summary = "사원 등록", description = "ADMIN 계정에서만 가능한 사원 등록 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeResponseDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<EmployeeResponseDto> registerEmployee(
			@Parameter(name = "사원등록", in = ParameterIn.PATH, description = "사원 등록 정보", required = true) @Valid @RequestBody EmployeeRequestDto requestDto) {
		return ResponseEntity.ok(authService.registerEmployee(requestDto));
	}

	/**
	 * 전체 사원 조회
	 * 
	 * @return List<EmployeeListDto>
	 */
	@Operation(summary = "사원 리스트", description = "사원 정보 리스트 가져오기", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeListDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@GetMapping("/list")
	public ResponseEntity<List<EmployeeListDto>> findAllEmployee() {
		return ResponseEntity.ok(employeeService.findAllEmployee());
	}

	/**
	 * 특정 사원 조회
	 * 
	 * @param { employeeId }
	 * @return EmployeeInfoDto
	 * @throws IllegalAccessException
	 */
	@Operation(summary = "사원 조회", description = "사원 번호로 사원 정보 조회", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeInfoDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@GetMapping("{employeeId}")
	public ResponseEntity<EmployeeInfoResponse> findByRetiredEmployeeId (
			@Parameter(name = "employee_id", description = "사원 번호", in = ParameterIn.PATH) @PathVariable Long employeeId) {
		return ResponseEntity.ok(employeeService.findByEmployeeId(employeeId));
	}

	/**
	 * 마이페이지
	 * 
	 * @return EmployeeResponseDto
	 * @throws RuntimeException
	 */
	@Operation(summary = "마이페이지", description = "로그인 된 사원의 마이페이지", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeResponseDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@GetMapping("/mypage")
	public ResponseEntity<EmployeeResponseDto> getMyInfoBySecurity() {
		EmployeeResponseDto employeeResponseDto = employeeService.getMyInfoBySecurity();
		return ResponseEntity.ok(employeeResponseDto);
	}

	/**
	 * 마이페이지 수정
	 * 
	 * @param { employeeEmail, exPassword, newPassword, employeeName, employeePhone,
	 *          employeeAddress, employeeImage } ChangeMyProfile
	 * @return EmployeeResponseDto
	 * @throws RuntimeException
	 */
	@Operation(summary = "마이페이지 정보 재설정", description = "마이페이지 정보(이메일, 비밀번호, 이름, 전화번호, 주소, 사진) 재설정)", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = EmployeeResponseDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@PostMapping("/edit")
	public ResponseEntity<EmployeeResponseDto> changeEmployeeProfile(
			@Parameter(name = "ChangePasswordRequestDto", description = "회원정보 재설정", in = ParameterIn.PATH) @Valid @RequestBody final ChangeMyProfile requestDto) {
		return ResponseEntity.ok(employeeService.changeEmployeeProfile(requestDto));
	}

	/**
	 * 특정 사원 삭제
	 * 
	 * @param { employeeId }
	 * @return void
	 * @throws IllegalAccessException
	 */
	@DeleteMapping("{employeeId}")
	@Operation(summary = "사원 삭제", description = "사원 번호로 사원 정보 삭제시 퇴사자 추가", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(example = "삭제 완료"))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<String> deleteEmployee(
			@Parameter(name = "employee_id", description = "사원 번호", in = ParameterIn.PATH) @PathVariable Long employeeId) {
		try {
			employeeService.deleteEmployee(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			// log 추가
		}
		return ResponseEntity.ok("삭제 성공");
	}

}

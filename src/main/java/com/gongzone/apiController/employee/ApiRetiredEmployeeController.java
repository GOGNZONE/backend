package com.gongzone.apiController.employee;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.employee.RetiredEmployeeDto.RetiredEmployeeResponse;
import com.gongzone.service.implement.employee.RetiredEmployeeServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/retired-employee")
@RequiredArgsConstructor
public class ApiRetiredEmployeeController {
	
	private final RetiredEmployeeServiceImpl retiredEmployeeService;
	
	/**
	 *  전체 퇴사자 조회
	 *  @return List<EmployeeListDto>
	 */
	@ApiOperation(value = "전체 퇴사자 조회", notes = "전체 퇴사자 조회")
	@GetMapping("/list")
	@Operation(summary = "전체 퇴사자 조회", description = "ADMIN 계정에서만 가능한 퇴사자 조회 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RetiredEmployeeResponse.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<List<RetiredEmployeeResponse>> findAllEmployee() {
		return ResponseEntity.ok(retiredEmployeeService.findAllRetiredEmployee());
	}
	
	/**
	 * 퇴사자 상세 조회
	 * @return RetiredEmployeeDto
	 * @throws IllegalAccessException 
	 * */
	@ApiOperation(value = "해당 퇴사자 조회", notes = "해당 퇴사자 조회")
	@Operation(summary = "퇴사자 상세 조회", description = "ADMIN 계정에서만 가능한 퇴사자 상세 조회 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RetiredEmployeeResponse.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@GetMapping("{retiredEmployeeId}")
	public ResponseEntity<RetiredEmployeeResponse> findByRetiredEmployeeId(@PathVariable Long retiredEmployeeId) {
			return ResponseEntity.ok().body(retiredEmployeeService.findByRetiredEmployeeId(retiredEmployeeId));
	}
	
	/**
	 * 퇴사자 삭제
	 * @return success -> "삭제 성공"
	 * @throws IllegalAccessException 
	 * */
	@Operation(summary = "퇴사자 삭제", description = "ADMIN 계정에서만 가능한 퇴사자 삭제 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(example = "삭제 성공"))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	@DeleteMapping("{retiredEmployeeId}")
	public ResponseEntity<String> deleteRetiredEmployee(@PathVariable Long retiredEmployeeId) {
			retiredEmployeeService.deleteRetiredEmployee(retiredEmployeeId);
			return ResponseEntity.ok("삭제 성공");
	}
}

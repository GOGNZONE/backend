package com.gongzone.employee.apiController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.service.RetiredEmployeeServiceImpl;

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
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RetiredEmployeeDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<List<RetiredEmployeeDto>> findAllEmployee() {
		return ResponseEntity.ok(retiredEmployeeService.findAllRetiredEmployee());
	}
	
	/**
	 * 퇴사자 상세 조회
	 * @return RetiredEmployeeDto
	 * @throws IllegalAccessException 
	 * */
	@ApiOperation(value = "해당 퇴사자 조회", notes = "해당 퇴사자 조회")
	@Operation(summary = "퇴사자 상세 조회", description = "ADMIN 계정에서만 가능한 퇴사자 상세 조회 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = RetiredEmployeeDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
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
	@Operation(summary = "퇴사자 삭제", description = "ADMIN 계정에서만 가능한 퇴사자 삭제 기능", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(example = "삭제 완료"))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
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

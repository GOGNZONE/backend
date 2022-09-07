package com.gongzone.apiController.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeRequest;
import com.gongzone.dto.employee.AuthEmployeeDto.AuthEmployeeResponse;
import com.gongzone.dto.employee.TokenDto;
import com.gongzone.service.implement.employee.AuthServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthApiController {

	private final AuthServiceImpl authService;
	
	
	/**
	 * 사원 생성(회원가입)
	 * 초기 ADMIN 계정 생성시 사용
	 * @throws RuntimeException
	 * @param EmployeeRequestDto
	 * @return EmployeeResponseDto
	 * */
	@PostMapping("/register")
	@Operation(summary = "회원 생성", description = "최초 ADMIN 계정을 생성하기 위한 API", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = AuthEmployeeRequest.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<AuthEmployeeResponse> registerEmployee(@RequestBody AuthEmployeeRequest requestDto) {
		return ResponseEntity.ok(authService.registerEmployee(requestDto));
	}
	
	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	@PostMapping("/login")
	@Operation(summary = "로그인", description = "이메일, 패스워드 로그인 후 JWT 토큰 생성", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = TokenDto.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 요청입니다"))),
			@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "권한이 없습니다"))),
			@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "페이지를 찾을 수 없습니다"))),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버 에러"))) })
	public ResponseEntity<TokenDto> login(@RequestBody AuthEmployeeRequest requestDto) {
		return ResponseEntity.ok(authService.login(requestDto));
	}
}

package com.gongzone.employee.apiController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.EmployeeRequestDto;
import com.gongzone.employee.dto.EmployeeResponseDto;
import com.gongzone.employee.dto.TokenDto;
import com.gongzone.employee.service.AuthServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthApiController {

	private final AuthServiceImpl authService;
	
	
	/**
	 * 최조 ADMIN 계정 만들 때 사용
	 * */
//	@PostMapping("/register")
//	public ResponseEntity<EmployeeResponseDto> registerEmployee(@RequestBody EmployeeRequestDto requestDto) {
//		return ResponseEntity.ok(authService.registerEmployee(requestDto));
//	}
	
	/**
	 * 로그인
	 * 
	 * @param EmployeeRequestDto
	 * @return TokenDto
	 * */
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody EmployeeRequestDto requestDto) {
		return ResponseEntity.ok(authService.login(requestDto));
	}
}

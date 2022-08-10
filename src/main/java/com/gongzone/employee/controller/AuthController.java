package com.gongzone.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.employee.dto.TokenDto;
import com.gongzone.employee.dto.request.EmployeeRequestDto;
import com.gongzone.employee.dto.response.EmployeeResponseDto;
import com.gongzone.security.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<EmployeeResponseDto> signup(@RequestBody EmployeeRequestDto requestDto) {
		return ResponseEntity.ok(authService.signUp(requestDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody EmployeeRequestDto requesetDto) {
		return ResponseEntity.ok(authService.login(requesetDto));
	}
}

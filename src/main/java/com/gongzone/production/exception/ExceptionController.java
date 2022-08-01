package com.gongzone.production.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @RestController에서 발생한 Exception에 대한 처리를 담당하는 클래스
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@ControllerAdvice
public class ExceptionController {
	
	/* @validated 유효성체크에 통과하지 못하면 MethodArgumentNotValidException 이 발생한다. */
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {
//		log.error("MethodArgumentNotValidException : " + e.getMessage());
//		final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
//		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//	}
	
}

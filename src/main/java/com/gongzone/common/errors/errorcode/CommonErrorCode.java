package com.gongzone.common.errors.errorcode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 발생할 수 있는 에러 코드 정의
 * @author Hanju Park
 * @version 1.0
 * */
@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
	
	INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid parameter included"),
	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not exists"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
	;
	
	private final HttpStatus httpStatus;
	private final String message;

}
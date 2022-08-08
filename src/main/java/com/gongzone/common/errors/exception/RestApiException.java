package com.gongzone.common.errors.exception;

import com.gongzone.common.errors.errorcode.ErrorCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 언체크 예외(런타임 예외)를 상속받는 예외 클래스
 * @author Hanju Park
 * @version 1.0
 * */
@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ErrorCode errorCode;
	
}

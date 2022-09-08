package com.gongzone.common.errors.errorcode;

import org.springframework.http.HttpStatus;

/**
 * CommonErrorCode와 UserErrorCode의 공통 메소드로 추상화할 인터페이스 정의
 * @author Hanju Park
 * @version 1.0
 * */

public interface ErrorCode {
	
	String name();
	HttpStatus getHttpStatus();
	String getMessage();
	
}

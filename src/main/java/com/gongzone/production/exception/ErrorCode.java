package com.gongzone.production.exception;

import lombok.Getter;

/**
 * 발생할 에러에 대한 코드, 간단한 에러 설명
 * @author Hanju Park
 * @version 1.0
 * */
public enum ErrorCode {
	
	INVALID_INPUT_VALUE("422", "Invalid input value");
	
	@Getter
	private String code;
	
	@Getter
	private String description;
	
	ErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
}

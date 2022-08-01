package com.gongzone.production.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * API에 내려줄 에러 형태를 정하는 클래스
 * @author Hanju Park
 * @version 1.0
 * */
@Getter
@Setter
public class ErrorResponse {
	
	private String code;

    private String description;

    private String detail;

    public ErrorResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ErrorResponse(String code, String description, String detail) {
        this.code = code;
        this.description = description;
        this.detail = detail;
    }
	
}

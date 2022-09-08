package com.gongzone.common.errors.response;

import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 응답 클래스
 * @author Hanju Park
 * @version 1.0
 * */
@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
	
	private final String code;
	private final String message;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<ValidationError> errors;

	
	/**
	 * @Valid 를 사용했을 때 에러가 발생한 경우 어느 필드에서 에러가 발생했는지 응답을 위한 ValidationError 내부 정적 클래스
	 * @author Hanju Park
	 * @version 1.0
	 * */
	@Getter
	@Builder
	@RequiredArgsConstructor
	public static class ValidationError {
		
		private final String field;
		private final String message;
		
		public static ValidationError of(final FieldError fieldError) {
			return ValidationError.builder()
					.field(fieldError.getField())
					.message(fieldError.getDefaultMessage())
					.build();
		}
		
	}
	
}

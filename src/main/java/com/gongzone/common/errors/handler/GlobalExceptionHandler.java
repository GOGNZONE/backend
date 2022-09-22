package com.gongzone.common.errors.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.errorcode.ErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.common.errors.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 에러 처리
 * @author Hanju Park
 * @version 1.0
 * */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * RestApiException 에러 처리
	 * */
	@ExceptionHandler(RestApiException.class)
	public ResponseEntity<Object> handleFactoryException(final RestApiException e) {
		final ErrorCode errorCode = e.getErrorCode();
		return handleExceptionInternal(errorCode);
	}
	
	/**
	 * 잘못된 파라미터를 넘겼을 경우 발생하는 IllegalArgumentException 에러 처리
	 * */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgument(final IllegalArgumentException e) {
		log.warn("handleIllegalArgument", e);
		final ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
		return handleExceptionInternal(errorCode, e.getMessage());
	}
	
	/**
	 * @Valid 에 의한 유효성 검증에 실패했을 때 발생하는 IllegalArgumentException 에러 처리
	 * */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			final MethodArgumentNotValidException e,
			final HttpHeaders headers,
			final HttpStatus status,
			final WebRequest request) {
		log.warn("handleIllegalArgument", e);
		final ErrorCode errorCode = CommonErrorCode.INVALID_PARAMETER;
		return handleExceptionInternal(e, errorCode);
	}
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllException(final Exception ex) {
		log.warn("handleAllException", ex);
		final ErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
		return handleExceptionInternal(errorCode);
	}
	
	
	private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus())
				.body(makeErrorResponse(errorCode));
	}
	
	private ErrorResponse makeErrorResponse(final ErrorCode errorCode) {
		return ErrorResponse.builder()
				.code(errorCode.name())
				.message(errorCode.getMessage())
				.build();
	}
	
	private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode, final String message) {
		return ResponseEntity.status(errorCode.getHttpStatus())
				.body(makeErrorResponse(errorCode, message));
	}
	
	private ErrorResponse makeErrorResponse(final ErrorCode errorCode, final String message) {
		return ErrorResponse.builder()
				.code(errorCode.name())
				.message(message)
				.build();
	}
	
	private ResponseEntity<Object> handleExceptionInternal(final BindException e, final ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus())
				.body(makeErrorResponse(e, errorCode));
	}
	
	private ErrorResponse makeErrorResponse(final BindException e, final ErrorCode errorCode) {
		final List<ErrorResponse.ValidationError> validationErrorList = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(ErrorResponse.ValidationError::of)
				.collect(Collectors.toList());
		
		return ErrorResponse.builder()
				.code(errorCode.name())
				.message(errorCode.getMessage())
				.errors(validationErrorList)
				.build();
	}
	
}

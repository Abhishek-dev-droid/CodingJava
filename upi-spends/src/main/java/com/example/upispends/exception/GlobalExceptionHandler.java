package com.example.upispends.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String msg = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getField() + ": " + e.getDefaultMessage())
				.collect(Collectors.joining(", "));
		return new ResponseEntity<>(new ApiError(status.value(), HttpStatus.valueOf(status.value()).getReasonPhrase(), msg), HttpStatus.valueOf(status.value()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleAll(Exception ex) {
		return new ResponseEntity<>(new ApiError(500, "Internal Server Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
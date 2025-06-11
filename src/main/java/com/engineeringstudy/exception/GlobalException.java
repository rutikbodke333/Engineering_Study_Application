package com.engineeringstudy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.engineeringstudy.entity.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleException(Exception e) {
		
		ApiResponse response = new ApiResponse();
		response.setExMsg(e.getMessage());
		response.setExCode("HX404");
		response.setLocalDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
		
	}

}

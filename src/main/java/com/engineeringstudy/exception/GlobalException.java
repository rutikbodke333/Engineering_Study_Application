package com.engineeringstudy.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(value =   MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> beanValidationException(MethodArgumentNotValidException e){
		
		Map<String, String> map = new HashMap<>();
	    e.getBindingResult().getAllErrors().forEach( (error) -> {
	    	String fieldName = ( (FieldError)error ).getField();
	    	String defaultMessage = error.getDefaultMessage();
	    	map.put(fieldName, defaultMessage);
	    });
	    
	    return new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		
	}
	
	
	

}

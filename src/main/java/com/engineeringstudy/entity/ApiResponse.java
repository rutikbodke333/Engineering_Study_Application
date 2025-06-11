package com.engineeringstudy.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

	
	private String exCode;
	private String exMsg;
	private LocalDateTime localDateTime;
}

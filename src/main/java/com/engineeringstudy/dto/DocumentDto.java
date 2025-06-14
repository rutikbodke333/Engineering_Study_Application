package com.engineeringstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {

	private Long id;

	private String title;

	private String documentType;

	private String branch;

	private String semester;

	private String academicYear;

	private String department;

	private String filePath;

	private UserDto user; // to avoid recursion, we use UserDto
}

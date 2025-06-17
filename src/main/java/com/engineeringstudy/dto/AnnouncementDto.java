package com.engineeringstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.engineeringstudy.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {

	private Long id;

	@NotBlank(message = "title cannot be blank")
	@Size(min = 4, max = 50, message = "title must be between 4 and 20 characters")
	private String title;

	@NotBlank(message = "content cannot be blank")
	@Size(min = 10, max = 500, message = "content must be between 10 and 500 characters")
	private String content;

	@NotBlank(message = "created by cannot be blank")
	@Size(min = 4, max = 20, message = "created by must be between 4 and 20 characters")
	private String createdBy;

	@NotBlank(message = "target audience cannot be blank")
	@Size(min = 4, max = 20, message = "target audience must be between 4 and 20 characters")
	private String targetAudience;

	private LocalDateTime createdAt;

	private LocalDateTime expiryDate;

	
}

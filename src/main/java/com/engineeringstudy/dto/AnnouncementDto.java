package com.engineeringstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.engineeringstudy.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {

	private Long id;
	private String title;
	private String content;
	private String createdBy;
	private String targetAudience;
	private LocalDateTime createdAt;
	private LocalDateTime expiryDate;
	private UserDto user; // to avoid recursion , we use UserDto 
}


package com.engineeringstudy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	@NotBlank(message = "Name must be not blank")
	@Size(min = 4, max = 30, message = "Name must have min 4 characters and max 20 characters")
	private String name;

	@NotBlank(message = "Email must be not blank")
	@Size(min = 8, max = 30, message = "Email must have min 8 characters and max 30 characters")
	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Password must be not blank")
	@Size(min = 6, max = 20, message = "Password must have min 6 characters and max 20 characters")
	private String password;

	private String role;

}

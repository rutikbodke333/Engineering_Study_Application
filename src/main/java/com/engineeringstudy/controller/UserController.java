package com.engineeringstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	public UserServiceImpl userServiceImpl;
	
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(UserDto userDto) {
		
		UserDto createdUser = this.userServiceImpl.updateUser(userDto);
		
		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(Long id) {
		
		UserDto user = this.userServiceImpl.getUserById(id);
		
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		
		List<UserDto> users = this.userServiceImpl.getAllUsers();
		
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(Long id) {
		
		this.userServiceImpl.deleteUserById(id);
		
		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
		
	}

}

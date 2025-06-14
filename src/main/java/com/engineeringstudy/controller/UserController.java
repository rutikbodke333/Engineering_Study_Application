package com.engineeringstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.service.UserService;
import com.engineeringstudy.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto) {

		UserDto createdUser = userService.createUser(userDto);

		return new ResponseEntity<UserDto>(createdUser, HttpStatus.CREATED);

	}
	
	
	@PutMapping("/user")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {

		UserDto updateUser = userService.updateUser(userDto);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable  Long id) {

		UserDto user = userService.getUserById(id);

		return new ResponseEntity<UserDto>(user, HttpStatus.OK);

	}

	@GetMapping("/users")
	public ResponseEntity<PaginationResponce> getAllUsers(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "name") String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir

	) {

		PaginationResponce paginationResponse = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PaginationResponce>(paginationResponse, HttpStatus.OK);

	}
	
	

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable  Long id) {

		userService.deleteUserById(id);

		return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);

	}

}

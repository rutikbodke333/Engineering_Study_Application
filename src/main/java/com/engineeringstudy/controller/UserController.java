package com.engineeringstudy.controller;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engineeringstudy")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/admin/users")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Long id) {
		UserDto updateUser = userService.updateUser(userDto, id);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		UserDto user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/user/allUsers")
	public ResponseEntity<PaginationResponce> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "15") Integer pageSize, @RequestParam(defaultValue = "name") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {
		PaginationResponce paginationResponse = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<>(paginationResponse, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

}

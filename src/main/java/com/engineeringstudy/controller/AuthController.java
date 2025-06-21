package com.engineeringstudy.controller;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.security.AuthRequest;
import com.engineeringstudy.security.JwtUtil;
import com.engineeringstudy.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engineeringstudy/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = userService.registerUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthRequest request) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

			if (authentication.isAuthenticated()) {
				String jwtToken = jwtUtil.generateToken(request.getEmail());
				return ResponseEntity.ok("Bearer " + jwtToken);
			} else {
				return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("Authentication failed: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the protected endpoint!";
	}
}

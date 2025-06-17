package com.engineeringstudy.service;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.entity.User;
import com.engineeringstudy.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto registerUser(UserDto userDto) {

		User user = modelMapper.map(userDto, User.class);

		// Encode the password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER"); 
		
		User savedUser = userRepository.save(user);

		return modelMapper.map(savedUser, UserDto.class);

	}

	@Override
	public UserDto createUser(UserDto userDto) {
		// Check if email already exists
		if (userRepository.existsByEmail(userDto.getEmail())) {
			throw new RuntimeException("Email already registered: " + userDto.getEmail());
		}

		User user = modelMapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_ADMIN");
		User savedUser = userRepository.save(user);

		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
	    // Check if the user exists
	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	    
	    existingUser.setName(userDto.getName());
	    existingUser.setEmail(userDto.getEmail());
	    existingUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
	    existingUser.setRole(userDto.getRole()); // Ensure the role is set correctly

	   
	    User upsertUser = userRepository.save(existingUser);

	    return modelMapper.map(upsertUser, UserDto.class);
	}


	@Override
	public UserDto getUserById(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public PaginationResponce getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}
//		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<User> page = userRepository.findAll(pageable);

		List<User> users = page.getContent();

		List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		PaginationResponce paginationResponce = new PaginationResponce();
		paginationResponce.setContent(userDtos);
		paginationResponce.setPageNumber(page.getNumber());
		paginationResponce.setPageSize(page.getSize());
		paginationResponce.setTotalElements(page.getTotalElements());
		paginationResponce.setTotalPages(page.getTotalPages());
		paginationResponce.setLastPage(page.isLast());

		return paginationResponce;

	}

	@Override
	public void deleteUserById(Long id) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
		userRepository.delete(user);

	}

}

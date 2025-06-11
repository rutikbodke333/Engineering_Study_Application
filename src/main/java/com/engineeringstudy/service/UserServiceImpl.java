package com.engineeringstudy.service;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.entity.User;
import com.engineeringstudy.exception.UserNotFoundException;
import com.engineeringstudy.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User upsertUser = userRepository.save(user);

		return modelMapper.map(upsertUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(Long id) {
		
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		 List<UserDto> userDtos = users.stream()
				.map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		 
		 return userDtos;
		
	}

	@Override
	public void deleteUserById(Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		userRepository.delete(user);

	}

}

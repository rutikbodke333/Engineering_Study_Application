package com.engineeringstudy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.engineeringstudy.dto.UserDto;
import com.engineeringstudy.entity.PaginationResponce;
import com.engineeringstudy.entity.User;

@Service
public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Long adminId);

	UserDto getUserById(Long id);

	PaginationResponce getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	void deleteUserById(Long id);

	public UserDto registerUser(UserDto userDto);
}

package com.engineeringstudy.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.engineeringstudy.dto.UserDto;


@Service
public interface UserService {

   

    UserDto updateUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    void deleteUserById(Long id);
}

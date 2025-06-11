package com.engineeringstudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engineeringstudy.entity.User;




public interface UserRepository  extends JpaRepository<User, Long> {

	
	

}

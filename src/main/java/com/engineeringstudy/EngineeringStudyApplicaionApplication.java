package com.engineeringstudy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


 

@SpringBootApplication
@EnableScheduling  //It is used to enable scheduling support in a Spring application.
public class EngineeringStudyApplicaionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineeringStudyApplicaionApplication.class, args);
	}
	
	@Bean
    ModelMapper modelMapper(){
		return new ModelMapper();
	}

}

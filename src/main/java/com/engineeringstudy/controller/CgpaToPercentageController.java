package com.engineeringstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineeringstudy.dto.CgpaToPercentageDto;
import com.engineeringstudy.exception.InvalidCgpaException;
import com.engineeringstudy.service.CgpaToPercentageService;

@RestController
public class CgpaToPercentageController {

	@Autowired
	CgpaToPercentageService cgpaToPercentageService;

	@PostMapping("/convertCgpaToPercentage")
	public ResponseEntity<String> convertCgpaToPercentage(@RequestBody CgpaToPercentageDto cgpaToPercentageDto) {

		
		if (cgpaToPercentageDto.getCgpa() == null) {
	        throw new InvalidCgpaException("CGPA is null. Please provide a valid CGPA value.");
	    }
		double cgpa = cgpaToPercentageDto.getCgpa();
		Double percentage = cgpaToPercentageService.convertCgpaToPercentage(cgpa);

		return new ResponseEntity<>("Percentage: " + percentage, HttpStatus.OK);

	}

}

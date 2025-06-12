package com.engineeringstudy.service;

import org.springframework.stereotype.Service;

@Service
public class CgpaToPercentageServiceImple implements CgpaToPercentageService {

	@Override
	public Double convertCgpaToPercentage(Double cgpa) {
		
		Double percentage = 0.0;
		
		if(cgpa != null) {
			
			percentage = (7.4 * cgpa) + 11.3;
		}
		else {
			throw new IllegalArgumentException("CGPA is null. Please provide a valid CGPA value.");
		}
		return percentage;
	}

}

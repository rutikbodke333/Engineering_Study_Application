package com.engineeringstudy.service;

import org.springframework.stereotype.Service;

import com.engineeringstudy.exception.InvalidCgpaException;

@Service
public class CgpaToPercentageServiceImple implements CgpaToPercentageService {

	@Override
	public Double convertCgpaToPercentage(Double cgpa) {

		Double percentage = 0.0;

		if (cgpa >= 1.0 && cgpa <= 10.0) {

			percentage = (7.4 * cgpa) + 11.3;
		} else {
			throw new InvalidCgpaException("Invalid CGPA value: " + cgpa + " and CGPA must be between 1.0 and 10.0.");

		}
		return percentage;
	}

}

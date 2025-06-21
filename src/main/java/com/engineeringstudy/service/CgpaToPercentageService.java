package com.engineeringstudy.service;

import org.springframework.stereotype.Service;

@Service
public interface CgpaToPercentageService {

	public Double convertCgpaToPercentage(Double cgpa);

}

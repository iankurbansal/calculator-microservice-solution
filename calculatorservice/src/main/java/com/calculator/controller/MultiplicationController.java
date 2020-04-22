package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.beans.RequestBean;
import com.calculator.beans.ResponseBean;
import com.calculator.service.CalculationService;

@RestController
public class MultiplicationController {

	@Autowired
	private CalculationService calculationService;
	
	@PostMapping(value="/multiply", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean calculateMultiply(@RequestBody RequestBean requestBean) {

		return calculationService.getMultiplicationResult(requestBean);
	}
	
	@PostMapping(value="/addition", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean calculateAddition(@RequestBody RequestBean requestBean) {
		
		return calculationService.getAdditionResult(requestBean);
	}
}

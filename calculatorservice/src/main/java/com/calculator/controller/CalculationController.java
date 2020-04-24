package com.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.beans.RequestBean;
import com.calculator.beans.ResponseBean;
import com.calculator.service.CalculationService;

/**
 * Controller to handle calculation requests
 */
@RestController
public class CalculationController {

	@Autowired
	private CalculationService calculationService;
	Logger logger = LoggerFactory.getLogger(CalculationController.class);

	@PostMapping(value="/multiply", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean calculateMultiply(@RequestBody RequestBean requestBean) {
		logger.debug("request received to multiply. request {}",requestBean);
		return calculationService.getMultiplicationResult(requestBean);
	}
	
	@PostMapping(value="/addition", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean calculateAddition(@RequestBody RequestBean requestBean) {
		logger.debug("request received to add. request {}",requestBean);
		return calculationService.getAdditionResult(requestBean);
	}
}

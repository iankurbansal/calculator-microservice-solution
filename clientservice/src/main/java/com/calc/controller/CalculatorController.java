package com.calc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.beans.CalcRequestBean;
import com.calc.beans.CalculatedResponseBean;
import com.calc.service.OperationService;

/**
 * rest controller to handle calculation request from client
 */
@RestController
public class CalculatorController {
	
	@Autowired
	private OperationService operationService;
	Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	@PostMapping(value="/calculate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CalculatedResponseBean calculate(@RequestBody CalcRequestBean calcRequestBean) {
		logger.debug("received request to calculate. {}",calcRequestBean);
		return operationService.calculateOperations(calcRequestBean);
	}
}

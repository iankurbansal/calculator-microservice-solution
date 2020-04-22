package com.calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.beans.CalcRequestBean;
import com.calc.beans.CalculatedResponseBean;
import com.calc.service.OperationService;

@RestController
public class CalculatorController {
	
	@Autowired
	private OperationService operationService;
	
	@PostMapping(value="/calculate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CalculatedResponseBean calculate(@RequestBody CalcRequestBean calcRequestBean) {
		//CalculatedResponseBean calculatedResponseBean = new CalculatedResponseBean();
		return operationService.calculateOperations(calcRequestBean);
		
	}
}

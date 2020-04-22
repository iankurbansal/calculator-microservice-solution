package com.calc.service;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import com.calc.beans.CalcRequestBean;
import com.calc.beans.CalculatedResponseBean;
import com.calc.configuration.feign.CalculationServiceFeignConfig;

/**
 * 
 * @author Arindam
 *This is a load balanced Rest Client ( Ribbon client) which will call the calculation-service 
 *form consul discovery service
 */
@FeignClient(name="calculation-service",configuration=CalculationServiceFeignConfig.class)
public interface CalculationFeignService {
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "api/addition")
	public CalculatedResponseBean calculateAddition(CalcRequestBean requestBean);
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, value = "api/multiply")
	public CalculatedResponseBean calculateMultiplication(CalcRequestBean requestBean);
	

}

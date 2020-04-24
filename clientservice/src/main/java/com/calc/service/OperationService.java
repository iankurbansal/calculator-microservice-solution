package com.calc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calc.beans.CalcRequestBean;
import com.calc.beans.CalculatedResponseBean;
import com.calc.constant.OperationTypeEnum;
import com.calc.constant.ResponseEnum;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import feign.FeignException;

@Service
public class OperationService {
	
	
	@Autowired
	private CalculationFeignService calculationFeignService;
	
	/**
	 * 
	 * @param requestBean
	 * @return
	 * @throws FeignException
	 * Hystrix fallbackMethod is configured, if calculationFeignService(calculation-service)
	 * is not available then this fallback function will get executed
	 * 
	 */
	@HystrixCommand(fallbackMethod = "fallbackCalculateOperations") 
	public CalculatedResponseBean calculateOperations(CalcRequestBean requestBean) throws FeignException {
		
		CalculatedResponseBean calculatedResponseBean = null;
		if(requestBean == null || requestBean.getOperator()==null) {
			// Return Error response
			return null;
		}else {
			
			OperationTypeEnum operationType = OperationTypeEnum.
					getOperationTypeEnumByoperator(requestBean.getOperator());
			switch (operationType) {
				case ADDITION:
					calculatedResponseBean =  calculationFeignService.calculateAddition(requestBean);
					break;
				case SUBTRUCTION:
					break;
				case MULTIPLICATION:
					calculatedResponseBean =  calculationFeignService.calculateMultiplication(requestBean);
					break;
				case DIVISION:
					break;
				default:
					break;
			}
		}
		return calculatedResponseBean;
	}
	
	public CalculatedResponseBean fallbackCalculateOperations(CalcRequestBean requestBean) {
		
		CalculatedResponseBean responseBean = new CalculatedResponseBean();
		responseBean.setResult(0.00);
		responseBean.setResponseCode(ResponseEnum.FAILED.getCode());
		responseBean.setResponseMessage(ResponseEnum.FAILED.getMessage());
		return responseBean;
	}
}

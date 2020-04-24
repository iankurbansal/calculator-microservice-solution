package com.calculator.service;

import org.springframework.stereotype.Service;

import com.calculator.beans.RequestBean;
import com.calculator.beans.ResponseBean;
import com.calculator.constant.ResponseEnum;

@Service
public class CalculationService {
	
	/**
	 * 
	 * @param requestBean
	 * @return ResponseBean
	 * 
	 */
	public ResponseBean getMultiplicationResult(RequestBean requestBean) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setResult(requestBean.getOperandOne()*requestBean.getOperandTwo());
		responseBean.setResponseCode(ResponseEnum.SUCCESS.getCode());
		responseBean.setResponseMessage(ResponseEnum.SUCCESS.getMessage());
		return responseBean;
	}
	
	/**
	 * 
	 * @param requestBean
	 * @return ResponseBean
	 */
	public ResponseBean getAdditionResult(RequestBean requestBean) {
		ResponseBean responseBean = new ResponseBean();
		responseBean.setResult(requestBean.getOperandOne()+ requestBean.getOperandTwo());
		responseBean.setResponseCode(ResponseEnum.SUCCESS.getCode());
		responseBean.setResponseMessage(ResponseEnum.SUCCESS.getMessage());
		return responseBean;
	}
}	

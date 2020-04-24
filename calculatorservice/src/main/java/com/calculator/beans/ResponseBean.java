package com.calculator.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ResponseBean to be sent to client. Should contain valid result
 */
@Data
@ApiModel
public class ResponseBean {
	
	@ApiModelProperty(notes = "Result of the Operation performed", 
            example = "33.2", position = 0)
	private Double result;
	
	@ApiModelProperty(notes = "Response Code for this operation", 
            example = "2000", position = 1)
	private Integer responseCode;
	
	@ApiModelProperty(notes = "Response Message for this operation", 
            example = "SUCCESS", position = 2)
	private String responseMessage;
}

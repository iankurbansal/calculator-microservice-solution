package com.calculator.beans;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * RequestBean to be received from the client
 */
@ApiModel(description = "Calculation Request Object")
@Data
public class RequestBean {
	
	@ApiModelProperty(notes = "Operend One for the Operation you are gong to perform", 
            example = "10.5", required = true, position = 0)
	@NotNull(message = "OperandOne should be a number, can't be empty")
	private Double operandOne;
	
	@ApiModelProperty(notes = "Operend Two for the Operation you are gong to perform", 
            example = "22.7", required = true, position = 1)
	@NotNull(message = "OperandTwo should be a number, can't be empty")
	private Double operandTwo;
	
}

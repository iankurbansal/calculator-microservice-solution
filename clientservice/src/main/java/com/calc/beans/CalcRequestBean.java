package com.calc.beans;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Calculator Request Object")
@Data
public class CalcRequestBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Operend One for the Operation you are gong to perform", 
            example = "10.5", required = true, position = 0)
	@NotNull(message = "{operand.one.not.empty}")
	private Double operandOne;
	
	@ApiModelProperty(notes = "Operend Two for the Operation you are gong to perform", 
            example = "22.7", required = true, position = 1)
	@NotNull(message = "{operand.two.not.empty}")
	private Double operandTwo;
	
	@ApiModelProperty(notes = "Operator sign for the Operation you are gong to perform", 
            example = "+", required = true, position = 2)
	@NotNull(message = "{operator.not.empty}")
	@Size(max = 1)
	private Character operator;
}

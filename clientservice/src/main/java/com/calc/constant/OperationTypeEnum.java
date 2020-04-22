package com.calc.constant;

/**
 * 
 * @author Arindam
 * This Enum is to beautify the operation service switch case
 * For any new Operation to support add an entry in this Enum
 *
 */
public enum OperationTypeEnum {
	
	ADDITION('+', "ADDITION"),
	SUBTRUCTION('-', "SUBTRUCTION"),
	MULTIPLICATION('*', "MULTIPLICATION"),
	DIVISION('/', "DIVISION");
	
	private Character operator;
	private String name;
	
	
	public Character getOperator() {
		return operator;
	}


	public String getName() {
		return name;
	}


	OperationTypeEnum(Character operator, String name){
		this.operator = operator;
		this.name = name;
	}
	
	
	public static OperationTypeEnum getOperationTypeEnumByoperator(Character inputOperator) {
		
		 for (OperationTypeEnum operatorType : OperationTypeEnum.values()) {
			if(operatorType.getOperator().equals(inputOperator)) {
				return operatorType;
			}
		} 
		 return null;
	}
}

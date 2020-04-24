package com.calc.constant;

public enum ResponseEnum {
	
	SUCCESS(200, "Success"),
	FAILED(400, "Failed Service Not Available"),
	ERROR(500, "Error");
	
	private Integer code;
	private String message;
	
	ResponseEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

package com.springimplant.connectionpooling.exceptions;

public class EmptyInputException extends RuntimeException {

	private static final long serialVersionUID = -3194419723112325170L;
	
	private String errorCode;
	private String errorMessage;
	
	public EmptyInputException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode=errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public static long getSerialversionid() {
		return serialVersionUID;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

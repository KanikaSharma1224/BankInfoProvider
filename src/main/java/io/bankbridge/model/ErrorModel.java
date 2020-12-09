package io.bankbridge.model;

public class ErrorModel {
	public String errorCode;
	public String details;

	public ErrorModel(String errorCode, String details) {
		this.errorCode = errorCode;
		this.details = details;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorModel [errorCode=" + errorCode + ", details=" + details + "]";
	}
	
	

}

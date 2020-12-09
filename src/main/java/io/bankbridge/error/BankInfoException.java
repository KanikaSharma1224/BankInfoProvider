package io.bankbridge.error;

public class BankInfoException extends Exception {
	public String erCode = "001";
	public String erDetails = "JSON Parsing Exception occured";

	public BankInfoException() {
		super();
	}

	public String getErCode() {
		return erCode;
	}

	public String getErDetails() {
		return erDetails;
	}

	public BankInfoException(String erCode, String erDetails) {
		super();
		this.erCode = erCode;
		this.erDetails = erDetails;
	}

	@Override
	public String toString() {
		return "BankInfoException [erCode=" + erCode + ", erDetails=" + erDetails + "]";
	}

}

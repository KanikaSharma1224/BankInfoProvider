package io.bankbridge.error;

public class CacheException extends BankInfoException {
	public String erCode = "002";
	public String erDetails = "Caching Exception occured";

	public CacheException() {

	}

	public String getErCode() {
		return erCode;
	}

	public void setErCode(String erCode) {
		this.erCode = erCode;
	}

	public String getErDetails() {
		return erDetails;
	}

	public void setErDetails(String erDetails) {
		this.erDetails = erDetails;
	}

	@Override
	public String toString() {
		return "CacheException [erCode=" + erCode + ", erDetails=" + erDetails + "]";
	}
	

}

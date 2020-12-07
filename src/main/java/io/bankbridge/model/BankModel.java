package io.bankbridge.model;

public class BankModel {
	
	public String bic;
	public String name;
	public String countryCode;
	public String auth;

	public BankModel() {

	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "BankModel [bic=" + bic + ", name=" + name + ", countryCode=" + countryCode + ", auth=" + auth + "]";
	}

}

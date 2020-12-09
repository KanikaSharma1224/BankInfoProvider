package io.bankbridge.error;

import io.bankbridge.model.ErrorModel;

public class ErrorHandler {
	public static ErrorModel erModel;
	public static ErrorModel generateError(Exception ex) {
		if(ex instanceof BankInfoException) {
			erModel = new ErrorModel(((BankInfoException) ex).getErCode(), ((BankInfoException) ex).getErDetails());
		}else if(ex instanceof CacheException){
			erModel = new ErrorModel(((CacheException) ex).getErCode(), ((CacheException) ex).getErDetails());
		}else {
			erModel = new ErrorModel("100","Internal service error occured");
		}
		
		return erModel;
	}

	
	public static BankInfoException generateJsonException() {
		return new BankInfoException("001","JSON Parsing exception occured");
	}

	public static Exception generateFatalException() {
		return new BankInfoException("100","Internal service error occured");
	}
	
}

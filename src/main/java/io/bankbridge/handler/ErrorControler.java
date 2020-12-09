package io.bankbridge.handler;

import io.bankbridge.error.BankInfoException;
import io.bankbridge.error.ErrorHandler;
import io.bankbridge.model.ErrorModel;
import io.bankbridge.util.JsonUtils;
import spark.Request;
import spark.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorControler {
	private static ErrorModel erModel;

	
	public static void handleErrors(Exception e, Request req, Response res) {
		try {
			erModel = ErrorHandler.generateError(e);
			res.body(JsonUtils.toJson(erModel));
		} catch (BankInfoException e1) {
			
		}
	}
}

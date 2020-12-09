package io.bankbridge.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.bankbridge.error.BankInfoException;
import io.bankbridge.error.ErrorHandler;

public class JsonUtils {
	private static ObjectMapper mapper;

	private JsonUtils() {
	}

	public static String toJson(Object ob) throws BankInfoException {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ob);
		} catch (JsonProcessingException e) {
			throw ErrorHandler.generateJsonException();
		}
	}

	public static ObjectMapper getObjectMapper() {
		if (mapper == null) {
			synchronized (JsonUtils.class) {
				mapper = new ObjectMapper();
				return mapper;
			}
		}
		return mapper;
	}

}

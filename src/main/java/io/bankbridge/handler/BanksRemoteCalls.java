package io.bankbridge.handler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.bankbridge.error.BankInfoException;
import io.bankbridge.model.BankModel;
import io.bankbridge.service.BankInfoService;
import io.bankbridge.service.BankRemoteInfoService;
import io.bankbridge.util.JsonUtils;
import spark.Request;
import spark.Response;

public class BanksRemoteCalls {

	public static String handle(Request request, Response response) throws IOException, BankInfoException {
		List<BankModel> result = BankRemoteInfoService.getBanksFromURL();
		String resultAsString = JsonUtils.toJson(result);
		return resultAsString;
	}

}

package io.bankbridge.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.bankbridge.error.BankInfoException;
import io.bankbridge.service.BankInfoService;

public class BanksRemoteConfigUtil {
	private static Logger logger = LoggerFactory.getLogger(BanksRemoteConfigUtil.class);
	private static HashMap<String, String> banksInfo;

	public static String[] getBankDetailsFromJson() throws IOException {
		banksInfo = JsonUtils.getObjectMapper()
				.readValue(Thread.currentThread().getContextClassLoader().getResource("banks-v2.json"), HashMap.class);
		List<String> list = new ArrayList<>();
		for (Entry<String, String> entry : banksInfo.entrySet()) {
			list.add(entry.getValue());
		}
		String[] urlList = list.toArray(new String[] {});
		return urlList;
	}

}

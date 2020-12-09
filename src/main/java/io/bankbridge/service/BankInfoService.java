package io.bankbridge.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ehcache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.bankbridge.model.BankModel;
import io.bankbridge.util.JsonUtils;

public class BankInfoService {
	private static Logger logger = LoggerFactory.getLogger(BankInfoService.class);

	private static CacheService cacheService;
	public static List<BankModel> banks = new ArrayList<>();

	public static List<BankModel> getBanks() throws IOException {
		Cache<String, BankModel> cache = cacheService.getCache();
		cache.forEach(entry -> {
			banks.add(entry.getValue());
		});
		return banks;
	}

}

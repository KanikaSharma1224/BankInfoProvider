package io.bankbridge.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ehcache.Cache;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.bankbridge.model.BankModel;

public class BankInfoService {
	private static CacheService cacheService;
	public static Map<String, BankModel> banks = new HashMap<>();

	public static Map<String, BankModel> getBanks() throws IOException {
		Cache<String, BankModel> cache = cacheService.getCache();
		cache.forEach(entry -> {
			banks.put(entry.getKey(), entry.getValue());
		});
		return banks;

	}

}

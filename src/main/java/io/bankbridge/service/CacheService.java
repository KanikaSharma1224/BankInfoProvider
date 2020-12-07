package io.bankbridge.service;

import java.io.IOException;

import org.ehcache.Cache;
import org.ehcache.CacheManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.bankbridge.model.BankModel;
import io.bankbridge.model.BankModelList;
import io.bankbridge.util.CacheUtils;
import io.bankbridge.util.JsonUtils;

public class CacheService {
	public static CacheUtils cacheUtils;

	public static Cache<String, BankModel> getCache() throws IOException {
		Cache<String, BankModel> cache = cacheUtils.getCacheForBanks();

		BankModelList models = JsonUtils.getObjectMapper().readValue(
				Thread.currentThread().getContextClassLoader().getResource("banks-v1.json"), BankModelList.class);
		for (BankModel model : models.banks) {
			cache.put(model.bic, model);
		}

		return cache;
	}

}

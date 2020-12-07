package io.bankbridge.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.bankbridge.error.BankInfoException;
import io.bankbridge.error.CacheException;
import io.bankbridge.error.ErrorHandler;
import io.bankbridge.model.BankModel;
import io.bankbridge.model.BankModelList;
import io.bankbridge.service.BankInfoService;
import io.bankbridge.service.CacheService;
import io.bankbridge.util.JsonUtils;
import spark.Request;
import spark.Response;

public class BanksCacheBased {

	public static String handle(Request request, Response response) throws Exception {
			Map<String, BankModel> result = BankInfoService.getBanks();
			String resultAsString = JsonUtils.toJson(result);
			return resultAsString;
	}

}

package io.bankbridge.util;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import io.bankbridge.model.BankModel;

public class CacheUtils {
	public static CacheManager cacheManager;

	public static CacheManager getCacheManager() {
		return CacheManagerBuilder
				.newCacheManagerBuilder().withCache("banks", CacheConfigurationBuilder
						.newCacheConfigurationBuilder(String.class, BankModel.class, ResourcePoolsBuilder.heap(10)))
				.build();
	}

	public static Cache<String, BankModel> getCacheForBanks() {
		CacheManager cacheManager = getCacheManager();
		cacheManager.init();
		return cacheManager.getCache("banks", String.class, BankModel.class);
	}

}

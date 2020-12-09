package io.bankbridge.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.apache.http.impl.client.CloseableHttpClient;

import io.bankbridge.model.BankModel;
import io.bankbridge.util.BanksRemoteConfigUtil;
import io.bankbridge.util.HttpClientUtil;
import io.bankbridge.util.HttpGetRequestTask;


public class BankRemoteInfoService {
	private static CloseableHttpClient httpClient;
	private static String[] urls;
	
	public static List<BankModel> getBanksFromURL() throws IOException {
		List<BankModel> banks = new ArrayList<>();
		httpClient = HttpClientUtil.getHttpClient();
		urls = BanksRemoteConfigUtil.getBankDetailsFromJson();
		HttpGetRequestTask task = new HttpGetRequestTask(urls, 0, urls.length);
		ForkJoinPool pool = new ForkJoinPool();
		banks = pool.invoke(task);
		return banks;	
	}
	
	

}

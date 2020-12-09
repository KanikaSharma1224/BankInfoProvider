package io.bankbridge.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bankbridge.error.ErrorHandler;
import io.bankbridge.model.BankModel;

public class HttpGetRequestTask extends RecursiveTask<List<BankModel>> {
	private static Logger logger = LoggerFactory.getLogger(HttpGetRequestTask.class);
	private String[] urls;
	private int start;
	private int end;

	public HttpGetRequestTask(String[] urls, int start, int end) {
		this.urls = urls;
		this.start = start;
		this.end = end;
	}

	@Override
	protected List<BankModel> compute() {
		int numTasks = end - start;

		if (numTasks <= 1) {
			try {
				return processRequest();
			} catch (ClientProtocolException e) {
				ErrorHandler.generateFatalException();

			} catch (IOException e) {
				ErrorHandler.generateJsonException();
			}
		}
		int middle = (end + start) / 2;
		HttpGetRequestTask subTask1 = new HttpGetRequestTask(urls, start, middle);
		subTask1.fork();
		HttpGetRequestTask subTask2 = new HttpGetRequestTask(urls, middle, end);
		subTask2.fork();
		List<BankModel> leftResults = subTask1.join();
		List<BankModel> rightResults = subTask2.join();
		return mergeResults(leftResults, rightResults);

	}

	private List<BankModel> processRequest() throws ClientProtocolException, IOException {
		String url = urls[start];
		List<BankModel> list = new ArrayList<>(urls.length);
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = HttpClientUtil.getHttpClient().execute(httpGet);
		BankModel bankModel = JsonUtils.getObjectMapper().readValue(httpResponse.getEntity().getContent(),
				BankModel.class);
		list.add(bankModel);
		return list;
	}

	private List<BankModel> mergeResults(List<BankModel> subTask1, List<BankModel> subTask2) {
		ArrayList<BankModel> results = new ArrayList<>(subTask1.size() + subTask2.size());
		results.addAll(subTask1);
		results.addAll(subTask2);
		return results;
	}

}

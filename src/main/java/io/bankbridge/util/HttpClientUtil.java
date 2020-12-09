package io.bankbridge.util;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientUtil {
	private static CloseableHttpClient httpClient;

	private HttpClientUtil() {
	}

	public static CloseableHttpClient getHttpClient() {
		if (httpClient == null) {
			synchronized (HttpClientUtil.class) {
				if (httpClient == null) {
					httpClient = HttpClients.createDefault();
					return httpClient;
				}

			}
		}
		return httpClient;
	}

}

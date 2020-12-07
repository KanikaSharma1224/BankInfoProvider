package io.bankbridge;
import static spark.Spark.get;
import static spark.Spark.port;

import io.bankbridge.error.CacheException;
import io.bankbridge.handler.BanksCacheBased;
import io.bankbridge.handler.BanksRemoteCalls;
import io.bankbridge.handler.ErrorControler;
import spark.Spark;

public class Main {

	public static void main(String[] args) throws Exception {
		
		port(8080);

		//BanksCacheBased.init();
		BanksRemoteCalls.init();
		
		get("/v1/banks/all", (request, response) -> BanksCacheBased.handle(request, response));
		get("/v2/banks/all", (request, response) -> BanksRemoteCalls.handle(request, response));
		
		Spark.exception(Exception.class, ErrorControler::handleErrors);
	}
}
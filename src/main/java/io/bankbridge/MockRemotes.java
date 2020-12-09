package io.bankbridge;
import static spark.Spark.get;
import static spark.Spark.port;

public class MockRemotes {

	public static void main(String[] args) throws Exception {
		
		port(1234);

		get("/rbb", (request, response) -> "{\n" + 
				"\"bic\":\"1234\",\n" + 
				"\"name\":\"Royal Buisness Bank\",\n" + 
				"\"countryCode\":\"GB\",\n" + 
				"\"auth\":\"OAUTH\"\n" + 
				"}");
		get("/cs", (request, response) -> "{\n" + 
				"\"bic\":\"5678\",\n" + 
				"\"name\":\"Credit Suise\",\n" +
				"\"countryCode\":\"CH\",\n" + 
				"\"auth\":\"OpenID\"\n" + 
				"}");
		get("/bes", (request, response) -> "{\n" + 
				"\"bic\":\"5555\",\n" + 
				"\"name\":\"Banco de espiritu santo\",\n" + 
				"\"countryCode\":\"PT\",\n" + 
				"\"auth\":\"SSL\"\n" + 
				"}");
	}
}
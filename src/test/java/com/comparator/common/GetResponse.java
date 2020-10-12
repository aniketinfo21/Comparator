package com.comparator.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResponse {
	
	public static Response request(String uri) {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given();
		return httpRequest.get().prettyPeek();

	}

}

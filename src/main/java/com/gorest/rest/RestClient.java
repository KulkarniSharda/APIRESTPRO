package com.gorest.rest;

import java.util.Map;
import java.util.Properties;
import com.gorest.config.ConfigurationManager;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

//	public static final String BASE_URI = "https://gorest.co.in";
//	public static final String AUTHORIZATION = "Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378";
   // baseuri is passing throungh parameter of testng file
	
	public static RequestSpecBuilder specBuilder;
	public boolean setDefaultAuthorization = false;
	public String baseURI;
	ConfigurationManager config = new ConfigurationManager();

	Properties prop;

//	static{
//		specBuilder = new RequestSpecBuilder();
//	}

	public RestClient(Properties prop, String baseURI) {
		specBuilder = new RequestSpecBuilder();
		this.baseURI = baseURI;
		// prop=config.init();
		this.prop = prop;

	}

	// Authorization
	private void addAuthorization() {
		if (!setDefaultAuthorization) {
			specBuilder.addHeader("Authorization", prop.getProperty("token"));
			setDefaultAuthorization = true;
		}

	}

	// ContentType

	private void setContentType(String contentType) {

		switch (contentType.toLowerCase()) {

		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;

		case "xml":
			specBuilder.setContentType(ContentType.XML);
			break;

		case "text":
			specBuilder.setContentType(ContentType.TEXT);
			break;

		default:
			System.out.println("Please provide the correct content type");
			// throw new APIFrameworkException("Invalid Content Type");
		}

	}

	// GET-given data --URI and Auth
	private RequestSpecification createRequestSpec(boolean includeToken) {
		specBuilder.setBaseUri(baseURI);
		if (includeToken) {
			addAuthorization();
		}
		return specBuilder.build();

	}

	// GET-given data --URI Auth and Headers
	private RequestSpecification createRequestSpec(Map<String, String> headers, boolean includeToken) {
		specBuilder.setBaseUri(baseURI);
		if (includeToken) {
			addAuthorization();
		}
		if (headers != null) {
			specBuilder.addHeaders(headers);
		}
		return specBuilder.build();

	}

	// GET-given data --URI Auth , Headers and params
	private RequestSpecification createRequestSpec(Map<String, String> headers, Map<String, String> params,
			boolean includeToken) {
		specBuilder.setBaseUri(baseURI);
		if (includeToken) {
			addAuthorization();
		}
		if (headers != null) {
			specBuilder.addHeaders(headers);
		}
		if (params != null) {
			specBuilder.addQueryParams(params);
		}
		return specBuilder.build();

	}

	// Post-given data --URI, Auth,contentType and Body
	private RequestSpecification createRequestSpec(String contentType, Object payload, boolean includeToken) {
		specBuilder.setBaseUri(baseURI);
		if (includeToken) {
			addAuthorization();
		}
		setContentType(contentType);
		if (payload != null) {
			specBuilder.setBody(payload);
		}
		return specBuilder.build();

	}

	// Post-given data --URI, Auth,contentType and Body
	private RequestSpecification createRequestSpec(String contentType, Object payload, Map<String, String> headers,
			boolean includeToken) {
		specBuilder.setBaseUri(baseURI);
		if (includeToken) {
			addAuthorization();
		}
		setContentType(contentType);
		if (payload != null) {
			specBuilder.setBody(payload);
		}
		if (headers != null) {
			specBuilder.addHeaders(headers);
		}
		return specBuilder.build();

	}

	// HTTPS methods

	// Pass URI and Auth
	public Response doGET(String basePath, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(includeAuth)).log().all().when().get(basePath);
		}
		return RestAssured.given(createRequestSpec(includeAuth)).when().get(basePath);

	}

	// GET -- URI,Auth and Headers
	public Response doGET(String basePath, Map<String, String> headers, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headers, includeAuth)).log().all().when().get(basePath);
		}
		return RestAssured.given(createRequestSpec(headers, includeAuth)).when().get(basePath);

	}

	// GET -- URI,Auth and Headers and Params
	public Response doGET(String basePath, Map<String, String> headers, Map<String, String> params, boolean includeAuth,
			boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headers, params, includeAuth)).log().all().when().get(basePath);
		}
		return RestAssured.given(createRequestSpec(headers, params, includeAuth)).when().get(basePath);

	}

//POST -- URI,Auth ,contentType and body
	public Response doPost(String basePath, String contentType, Object payload, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).log().all().when()
					.post(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).when().post(basePath);

	}

//POST -- URI,Auth ,contentType and body and Headers
	public Response doPost(String basePath, String contentType, Object payload, Map<String, String> headers,
			boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).log().all().when()
					.post(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).when().post(basePath);

	}

//PUT -- URI,Auth ,contentType and body
	public Response doPut(String basePath, String contentType, Object payload, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).log().all().when()
					.put(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).when().put(basePath);

	}

//PUT -- URI,Auth ,contentType and body and Headers
	public Response doPut(String basePath, String contentType, Object payload, Map<String, String> headers,
			boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).log().all().when()
					.put(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).when().put(basePath);

	}

//Patch -- URI,Auth ,contentType and body
	public Response doPatch(String basePath, String contentType, Object payload, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).log().all().when()
					.patch(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, includeAuth)).when().patch(basePath);

	}

//Patch -- URI,Auth ,contentType and body and Headers
	public Response doPatch(String basePath, String contentType, Object payload, Map<String, String> headers,
			boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).log().all().when()
					.patch(basePath);
		}
		return RestAssured.given(createRequestSpec(contentType, payload, headers, includeAuth)).when().patch(basePath);

	}

//Delete
	public Response doDelete(String basePath, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(includeAuth)).log().all().when().delete(basePath);
		}
		return RestAssured.given(createRequestSpec(includeAuth)).when().delete(basePath);

	}

//delete -- URI,Auth and Headers
	public Response doDelete(String basePath, Map<String, String> headers, boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headers, includeAuth)).log().all().when().delete(basePath);
		}
		return RestAssured.given(createRequestSpec(headers, includeAuth)).when().delete(basePath);

	}

//delete -- URI,Auth and Headers and Params
	public Response doDelete(String basePath, Map<String, String> headers, Map<String, String> params,
			boolean includeAuth, boolean log) {

		if (log) {
			return RestAssured.given(createRequestSpec(headers, params, includeAuth)).log().all().when()
					.delete(basePath);
		}
		return RestAssured.given(createRequestSpec(headers, params, includeAuth)).when().delete(basePath);

	}

}

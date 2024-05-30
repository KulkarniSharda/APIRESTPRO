package com.gorest.rest;

import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestClient1 {
	public static final String BASE_URI="https://gorest.co.in";
	public static final String AUTHORIZATION="Bearer 2043b7426a320fb4bbe283fef008aabf2ea1163e989c984c9b02facbe7f29378";
	
	public static RequestSpecBuilder specBuilder;
	
	static {
		
		 specBuilder=new RequestSpecBuilder();
	}
	
	//Authorization 
	public void addAuthorization() {
		specBuilder.addHeader("Authorization", AUTHORIZATION);
		
	}
	
	//ContentType
	
	public void setContentType(String contentType) {
		
		switch (contentType.toLowerCase()){
		
		case "json": specBuilder.setContentType(ContentType.JSON);
		break;
		
		case "xml": specBuilder.setContentType(ContentType.XML);
		break;
		
		case "text": specBuilder.setContentType(ContentType.TEXT);
		break;
		
		default:
			System.out.println("Please provide the correct content type");
			//throw new APIFrameworkException("Invalid Content Type");
		}

		}

	
	//given data --URI and Auth
	public RequestSpecification createRequestSpec() {
		specBuilder.setBaseUri(BASE_URI);
		addAuthorization();
		return specBuilder.build();
		
	}
	//given data --URI Auth and Headers
	public RequestSpecification createRequestSpec(Map<String,String> headers) {
		specBuilder.setBaseUri(BASE_URI);
		addAuthorization();
		if(headers!=null) {
			specBuilder.addHeaders(headers);
		}
		return specBuilder.build();
		
	}
	//given data --URI Auth , Headers and params
	public RequestSpecification createRequestSpec(Map<String,String> headers,Map<String,String> params) {
		specBuilder.setBaseUri(BASE_URI);
		addAuthorization();
		if(headers!=null) {
			specBuilder.addHeaders(headers);
		}
		if(params!=null) {
			specBuilder.addQueryParams(params);
		}
		return specBuilder.build();
		
	}
	
	//given data --URI, Auth,contentType and Body
		public RequestSpecification createRequestSpec(String contentType,Object payload) {
			specBuilder.setBaseUri(BASE_URI);
			addAuthorization();
			setContentType(contentType);
			if(payload!=null) {
				specBuilder.setBody(payload);
			}
			return specBuilder.build();
			
		}
			
			//given data --URI, Auth,contentType and Body
			public RequestSpecification createRequestSpec(String contentType,Object payload,Map<String,String> headers) {
				specBuilder.setBaseUri(BASE_URI);
				addAuthorization();
				setContentType(contentType);
				if(payload!=null) {
				specBuilder.setBody(payload);
				}	
					if(headers!=null) {
						specBuilder.addHeaders(headers);
					}
				return specBuilder.build();
				
			}
}

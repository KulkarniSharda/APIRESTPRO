package com.gorest.utilities;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class JaywayValidator {
	
public <T> T read(Response response,String jsonPath) {
		
		String jsonResponse=response.getBody().asString();
		
		try {
			return JsonPath.read(jsonResponse, jsonPath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FrameworkException(jsonPath+ "is not found ");
		}
	}
		public <T> List<T> readList(Response response,String jsonPath) {
			
			String jsonResponse=response.getBody().asString();
			
			try {
				return JsonPath.read(jsonResponse, jsonPath);
			} catch (Exception e) {
				e.printStackTrace();
				throw new FrameworkException(jsonPath+ "is not found ");
			}
			
		}	
			public <T> List<Map<String,T>> readListOfMaps(Response response,String jsonPath) {
				
				String jsonResponse=response.getBody().asString();
				
				try {
					return JsonPath.read(jsonResponse, jsonPath);
				} catch (Exception e) {
					e.printStackTrace();
					throw new FrameworkException(jsonPath+ "is not found ");
				}
	
	}

}

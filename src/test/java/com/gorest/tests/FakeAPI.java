package com.gorest.tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.base.BaseTest;
import com.gorest.rest.RestClient;
import com.gorest.utilities.HttpStatusCode;
import com.gorest.utilities.JaywayValidator;

import io.restassured.response.Response;

public class FakeAPI extends BaseTest{
	

	
	JaywayValidator jayway=new JaywayValidator();
RestClient rest;
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	
	
	@Test
	public void getAllUserFromReqRes() {
		
		//RestClient restClient=new RestClient(properties, baseURI);
		
		Response response=rest.doGET(FAKESTORE_BASHPATH, false,true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode()).extract().response();
		
		int length= jayway.read(response, "$.length()");
		System.out.println("size "+length);
		
		//Print the all price where id is 3 --$[?(@.id==3)].price
		
		List<Double> price= jayway.read(response, "$[?(@.id==3)].price");
		System.out.println("price of id 3==> "+price);
		
		for(Double p:price) {
			System.out.println(p);
		}
		
		//print the title and prices of the products where category is jewelery --$[?(@.category=="jewelery")].title,price

		   List<Map<String,Object>> value = jayway.read(response, "$[?(@.category==\"jewelery\")].[\"title\",\"price\"]");
		System.out.println("==> "+value);
		
		
		for(Map<String,Object> val:value) {
			
			String title=(String) val.get("title");
			Object price1= val.get("price");
			System.out.println("titile===>"+title);
			System.out.println("price===>"+price1);
			System.out.println("====================");
			
		}
		
		
		
	
	}


}

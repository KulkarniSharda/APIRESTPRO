package com.gorest.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gorest.config.ConfigurationManager;
import com.gorest.rest.RestClient;
//import com.gorest.rest.RestClient0;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {
	
	
	public static final String GOREST_BASHPATH="/public/v2/users";
	public static final String REQRES_BASHPATH="/api/users";
	public static final String FAKESTORE_BASHPATH="/products";
	public static final String GoREST_SHEETNAME="Sheet4";
	
	 protected ConfigurationManager config;
	 protected Properties properties;
	 protected RestClient restClient;
	 public  String baseURI;
	 
	
	 @BeforeTest
	 @Parameters({"baseURI"})
	public void setUP(String baseURI) {
		 
		 RestAssured.filters(new AllureRestAssured());  
		 // Create report by using Allure report 
		
		 config=new ConfigurationManager();
		
		 properties= config.init();
		
		//String baseURI=properties.getProperty("baseURI");
		 
		this.baseURI=baseURI;
		
		// restClient=new RestClient(properties, baseURI);
	}
	
	
	/*
	 * //old setup for base test protected ConfigurationManager config; protected
	 * Properties properties; protected RestClient0 restClient;
	 * 
	 * public void setUP() {
	 * 
	 * config = new ConfigurationManager();
	 * 
	 * properties = config.init();
	 * 
	 * String baseURI = properties.getProperty("baseURI");
	 * 
	 * restClient = new RestClient0(properties, baseURI); }
	 */
	
	
	

}

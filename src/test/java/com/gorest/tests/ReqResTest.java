package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.base.BaseTest;
import com.gorest.rest.RestClient;
import com.gorest.utilities.HttpStatusCode;

public class ReqResTest extends BaseTest{
	

	
RestClient rest;
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	
	
	@Test
	public void getAllUserFromReqRes() {
		
		//RestClient restClient=new RestClient(properties, baseURI);
		
		rest.doGET(REQRES_BASHPATH, false,true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.OK_200.getCode());
		
	
	}


}

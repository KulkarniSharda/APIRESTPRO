package com.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gorest.base.BaseTest;
import com.gorest.pojo.UserLombok;
import com.gorest.rest.RestClient;
import com.gorest.utilities.StringUtils;

public class EndToEndTest extends BaseTest{
	
	RestClient rest;
	
	@BeforeMethod
	public void setRestClient() {
		 rest=new RestClient(properties, baseURI);
	}
	
	@Test
	public void createSingleUser() {
		
		UserLombok user=new UserLombok("Ishwar", "male", StringUtils.randomEmailID(), "active");
		
		
	int id=	rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(201).extract().path("id");
	
	System.out.println("Id ==>"+id);
	
	//RestClient restGet=new RestClient(properties, baseURI);
	rest.doGET(GOREST_BASHPATH+id, true,true).then().log().all().statusCode(200);
	
	}
	
	

}

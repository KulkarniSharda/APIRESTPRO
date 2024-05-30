package com.gorest.tests;

import org.testng.annotations.Test;

import com.gorest.base.BaseTest;



public class GetTesto extends BaseTest {
	
	
	
	@Test
	public void getAllUserData() {
		
		//RestClient restClient=new RestClient();
		
		//restClient.doGET("/public/v2/users", true)
		//.then().log().all().assertThat().statusCode(200);
		
	
	}
	
	
//	@Test
//	public void getSingleUser() {
//		
//		RestClient restClient=new RestClient();
//		
//		restClient.doGET("/public/v2/users/6914512", true)
//		.then().log().all().assertThat().statusCode(200);
//		
//	
//	}
//	
//	@Test
//	public void getUserQueryParams() {
//		
//		RestClient restClient=new RestClient();
//		
//		Map<String,String> params=new HashMap<String,String>();
//		params.put("name", "Gangesh Varman");
//		params.put("gender", "female");
//		
//		restClient.doGET("/public/v2/users", null, params, true)
//		.then().log().all().assertThat().statusCode(200);
//		
//	
//	}

}

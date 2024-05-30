package com.gorest.tests;

import org.testng.annotations.Test;

import com.gorest.pojo.UserLombok;
import com.gorest.rest.RestClient0;
import com.gorest.utilities.StringUtils;

public class PostTesto {

	@Test
	public void createSingleUser() {

		UserLombok user = new UserLombok("Kulkarni", "male", StringUtils.randomEmailID(), "active");

		//RestClient rest = new RestClient();
		//rest.doPost("/public/v2/users", "Json", user, true).then().log().all().assertThat().statusCode(201);
	}

}

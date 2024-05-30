package com.gorest.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gorest.base.BaseTest;
import com.gorest.pojo.UserLombok;
import com.gorest.rest.RestClient;
import com.gorest.utilities.ExcelReader;
import com.gorest.utilities.HttpStatusCode;
import com.gorest.utilities.StringUtils;

public class PostTest extends BaseTest {
	RestClient rest;
	
	ExcelReader excel=new ExcelReader();
	
	@BeforeMethod
	public void setClient() {
		
		rest=new RestClient(properties, baseURI);
	}
	
	
	@DataProvider
	public Object[][] createUserData() {
		
		return new Object[][] {
			{"Arpit","male","active"},
			{"Selinda","female","active"},
			{"Lisa","female","inactive"},
		};
		
	}
	
	@DataProvider
	public Object[][] createUserExcelData() {
		
		try {
			return excel.excelReaderTest(GoREST_SHEETNAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Test(dataProvider ="createUserData",enabled=false )
	public void createSingleUser(String name,String gender,String status) {
		
		UserLombok user=new UserLombok(name, gender, StringUtils.randomEmailID(), status);
		
		
		rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.CREATED_201.getCode());
	}
	
	@Test(dataProvider ="createUserExcelData" )
	public void createSingleExcelUser(String name,String gender,String status) {
		
		UserLombok user=new UserLombok(name, gender, StringUtils.randomEmailID(), status);
		
		
		rest.doPost(GOREST_BASHPATH, "Json", user,true, true)
		.then().log().all().assertThat().statusCode(HttpStatusCode.CREATED_201.getCode());
	}

}

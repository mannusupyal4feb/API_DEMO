package com.api.restassured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_JsonValidate {
	
	@Test
	void getWeatherDetails()
	{
		//Specify the base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//to send the request
		RequestSpecification httprequest = RestAssured.given();
		
		//to get the response
		Response response  = httprequest.request(Method.GET,"/Delhi");
		
		
		//print the response
		String responseData = response.getBody().asString();
		System.out.println("Respnse is" + responseData);
		
		//validate the response body
		Assert.assertEquals(responseData.contains("Delhi"), true);
		System.out.println("PASS");
		
		
		
		
	}


}

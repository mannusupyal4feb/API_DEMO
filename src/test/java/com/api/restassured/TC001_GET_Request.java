package com.api.restassured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	
	@Test
	void getWeatherDetails()
	{
		//Specify the base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//to send the request
		RequestSpecification httprequest = RestAssured.given();
		
		//to get the response
		Response response  = httprequest.request(Method.GET,"/Hyderabad");
		
		
		//print the response
		String responseData = response.getBody().asString();
		System.out.println("Respnse is" + responseData);

		System.out.println("***************************************************");
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		AssertJUnit.assertEquals(statusCode, 200);
		System.out.println("PASS");
		

		System.out.println("***************************************************");
		
		//status line validation
		String statusLine = response.statusLine();
		System.out.println("Status line is " + statusLine);
		AssertJUnit.assertEquals(statusLine, "HTTP/1.1 200 OK");
		System.out.println("PASS");
		
		
	}

}

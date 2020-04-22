package com.api.restassured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Authentication {
	
	@Test
	void getAuthDetails()
	{
		//Specify the base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		
		// basic provide authentaction
		PreemptiveBasicAuthScheme authState  = new 	PreemptiveBasicAuthScheme();
		authState.setUserName("ToolsQA");
		authState.setPassword("TestPassword");
		
		RestAssured.authentication = authState;
		
		//to send the request
		RequestSpecification httprequest = RestAssured.given();
		
		
		//to get the response
		Response response  = httprequest.request(Method.GET,"/");
		
		
		
		//print the response
		String responseData = response.getBody().asString();
		System.out.println("Respnse is" + responseData);
		

		System.out.println("***************************************************");
		
		//status code validation
				int statusCode = response.getStatusCode();
				System.out.println("status code is " + statusCode);
				AssertJUnit.assertEquals(statusCode, 200);
				System.out.println("PASS");
				

				
				
		

}
}

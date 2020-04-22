package com.api.restassured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void registerSuccess()
	{
		//Specify the base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/customer";
		
		//to send the request (request object)
		RequestSpecification httprequest = RestAssured.given();
		
		//to send parameters use JSONObject
		JSONObject  requestParams = new JSONObject();
		requestParams.put("FirstName", "Johnffhhhhfffrrrmjrrrjjjtttjmmfmm");
		requestParams.put("LastName", "Cffenafffffffffjgdddtttjjghhhhjgff");
		requestParams.put("UserName", "JohggggnCfjjjdddddddddjjjgggddfffffdf");
		requestParams.put("Password", "johnckkkfffbbbssssssdddfffff");
		requestParams.put("Email", "JohnCvdvddhggggvvvvffffffssssfddggdddv@gmail.com");
		
		//specify which is request format
		httprequest.header("Content-Type","application/json");
		//convert into json format
		httprequest.body(requestParams.toJSONString());
		
		//to get the response (response object)
		Response response  = httprequest.request(Method.POST,"/register	");
		
		
		//print the response
		String responseData = response.getBody().asString();
		System.out.println("Respnse is" + responseData);

		System.out.println("***************************************************");
		//status code validation
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);
		Assert.assertEquals(statusCode, 201);
		System.out.println("PASS");
		

		System.out.println("***************************************************");
		
		//success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		System.out.println("PASS");
	}

}

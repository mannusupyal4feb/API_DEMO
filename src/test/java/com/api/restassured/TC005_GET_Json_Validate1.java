package com.api.restassured;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Json_Validate1 {
	
	@Test
	void getWeatherDetails()
	{
		//Specify the base uri
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//to send the request
		RequestSpecification httprequest = RestAssured.given();
		
		//to get the response
		Response response  = httprequest.request(Method.GET,"/Delhi");
		
		//to print Nodes in single ..use JSONPath
		JsonPath jsonPath = response.jsonPath();	//capture complete json response body
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));
		
		//validate
		
//		Assert.assertEquals(jsonPath.get("Temperature"), "28 Degree celsius");
//		System.out.println("Pass");
		
		AssertJUnit.assertEquals("Pass", "34 Degree celsius", jsonPath.get("Temperature"));

				
		

}
}

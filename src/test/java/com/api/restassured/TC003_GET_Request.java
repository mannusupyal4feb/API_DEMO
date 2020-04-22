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
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void getGoogleMapTest()
	{
		//Specify the base uri
		RestAssured.baseURI= "https://maps.googleapis.com";
		
		//to send the request
		RequestSpecification httprequest = RestAssured.given();
		
		//to get the response
		Response response  = httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmj2HoELb4Jy1s");
		
		
		//print the response
		String responseData = response.getBody().asString();
		System.out.println("Respnse is" + responseData);
			
		
		//one by one header validates and print
		//validation headers
		String contentType = response.header("Content-Type");		
		System.out.println(contentType);
		AssertJUnit.assertEquals(contentType, "application/json");
		
		//find all headers data at a time
		Headers  allHeaders = response.headers();
		for(Header header :allHeaders)
		{
			System.out.println(header.getName() +" " + header.getValue());
		}

		
	}

}

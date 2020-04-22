package DataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_Post {

	@Test(dataProvider = "empdata")
	public void createNewEmployee(String eName, String eAge, String eSalary)

	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		JSONObject objParams = new JSONObject();
		objParams.put("name", eName);
		objParams.put("salary", eAge);
		objParams.put("age", eSalary);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(objParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "/create");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		Assert.assertEquals(responseBody.contains(eName), true);

		Assert.assertEquals(responseBody.contains(eAge), true);

		Assert.assertEquals(responseBody.contains(eSalary), true);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "paas");

	}

	@DataProvider(name = "empdata")
	public String[][] getEmpData() throws IOException {

		String path = "/MyDocs/API/com.api.restassured/src/test/java/DataDrivenTesting/EmpData.xlsx";
		int rownum = xlUtils.getRowCount(path, "Sheet1");
		int colnum = xlUtils.getCellCount(path, "Sheet1", 1);

		String empData[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				empData[i - 1][j] = xlUtils.getCellData(path, "Sheet1", i, j);
			}

		}
		return (empData);
		// String empData[][] =
		// {{"abcf33","437373","34"},{"dfggcf33","43677373","24"},{"abfdddcf33","437555373","34"}};
	}

}

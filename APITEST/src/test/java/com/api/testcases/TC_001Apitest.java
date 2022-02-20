package com.api.testcases;


import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


// given() set cookies,add auth, add param, set headers
//when() get,post,put,delete
//then() validate status code,extract response,extract headers,response body


public class TC_001Apitest 

{
	//@Test
	public void test_GET() 
	
	{
		given()
		  .when()
		     .get("https://youtube.com")
		   .then()
		     .statusCode(200)
		     .log().body();	
	}
	
	//@Test
	public void test_POST() //append
	
	{
		
		HashMap data= new HashMap();
		data.put("id", "100");
		data.put("name", "pacman");
		
		given()
		.contentType("application/json")
		.body(data)
		  .when()
		     .post("https://youtube.com/customers/100")
		   .then()
		     .statusCode(200)
		     .log().body()
		       .body("youtube.id",equalTo("145"));	
		     
	}
	
	//@Test
     public void test_PUT() //update
	
	{
		
		HashMap data= new HashMap();
		data.put("id", "100");
		data.put("name", "graple");
		
		given()
		.contentType("application/json")
		.body(data)
		  .when()
		     .put("https://youtube.com/customers/100")
		   .then()
		     .statusCode(200)
		     .log().body()
		       .body("youtube.id",equalTo("145"));	
		     
	}
	
	//@Test
    public void test_DELETE() //update
	
	{
		Response res= 
				
		given()
		  .when()
		     .delete("https://youtube.com/customers/100")
		   .then()
		     .statusCode(200)
		     .log().body()
		      .extract().response();
		String jsonString = res.asString();
		Assert.assertEquals(jsonString.contains("Record deleted successfully"), true);
		     
	}
}

package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Beecaptor {
	
	// Base URL for the mock JSON API
	String BaseUrl = "https://json-placeholder.mock.beeceptor.com";
	
	/**
	* Test case to List all available blog posts.
	*/
	@Test(enabled = true, priority = 0)
	public void t1() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		   .contentType(ContentType.JSON)
		   .get("/posts")
		.then()
		   .statusCode(200) // Assert the status code is 200
		   .body("[0].title", equalTo("Introduction to Artificial Intelligence")) // validate title of first post
		   .log().all(); // Log the response for debugging
				
	}
	
	/**
	 *  Test case to retrieve a post by passing an integer ID
	 */
	@Test(enabled = true, priority = 1)
	public void t2() {
		
		RestAssured.baseURI = BaseUrl;
		
	    given()
	      .get("/posts/1") // Get post with ID 1
	    .then()
	      .statusCode(200) // Assert the status code is 200
	      .contentType(ContentType.JSON) // Assert content type
	      .body("body", equalTo("Learn the basics of Artificial Intelligence and its applications in various industries.")) // Validate post body
	      .log().all(); // Log the response for debugging
			
	}
	
	/**
	 * Test case to List all the blog comments.
	 */
	@Test(enabled = true, priority = 2)
	public void t3() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		  .get("/comments") // Get all comments
		.then()
		  .statusCode(200) // Assert the status code is 200
		  .contentType(ContentType.JSON) // Assert content type
		  .body("[0].email", equalTo("john.smith@example.com")) // Validate email of the first comment
		  .log().all(); // Log the response for debugging
	}
	
	/**
	 * Test case to retrieve a comment by passing and numeric/alphanumeric ID. 
	 */
	@Test(enabled = true, priority = 3)
	public void t4() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		  .get("/comments/1") // Get comment with ID 1
		.then()
		  .statusCode(200) // Assert the status code is 200
		  .contentType(ContentType.JSON) // Assert content type
		  .log().all(); // Log the response for debugging
		
	}
	
	/**
	 * Test case get a list of all the companies.
	 */
	@Test(enabled = true, priority = 4)
	public void t5() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		  .get("/companies") // Get all companies
		.then()
		  .statusCode(200) // Assert the status code is 200
		  .contentType(ContentType.JSON) // Assert content type
		  .body("[5].industry", equalTo("Food")) // Validate industry of the sixth company
		  .log().all(); // Log the response for debugging
	}
	
	/**
	 * Test case to retrieve details about a company by passing company ID.
	 */
	@Test(enabled = true, priority = 5)
	public void t6() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		  .get("/companies/7") // Get company with ID 7
		.then()
		  .statusCode(200) // Assert the status code is 200
		  .contentType(ContentType.JSON) // Assert content type
		  .log().all(); // Log the response for debugging
	}
	
	/**
	 * Test case to get a list of all the users.
	 * 
	 */
	@Test(enabled = true, priority = 6)
	public void t7() {
		
		RestAssured.baseURI = BaseUrl;
		
		JSONObject js = new JSONObject();
		
		js.put("username", "emily_johnson"); // Prepare JSON object with username
		
		given()
		  .contentType(ContentType.JSON)
		  .body(js.toString()) // Send JSON body
		  .get("/users") // Get all users
		.then()
		  .statusCode(200) // Assert the status code is 200
		  .log().all(); // Log the response for debugging
		
	}
	
	/**
	 * Test case for login example with failed attempt.
	 * Uses 'fail' keyword in the password to trigger a failure.
	 */
	@Test(enabled = true, priority = 7)
	public void login() {
		
		RestAssured.baseURI = BaseUrl;
		
		JSONObject requestBody = new JSONObject();
		
		  requestBody.put("username", "user123"); // Username for login
		  requestBody.put("password", "failed-password"); // Incorrect Password
		  
		  given()
		     .contentType(ContentType.JSON)
		     .body(requestBody.toString()) // Send JSON body
		  .when()
		     .post("/login") // Attempt to login
		  .then()
		     .statusCode(401) // Assert the status code is 401 for unauthorized
		     .log().all(); // Log the response for debugging
	}
	
	/**
	 * Test case for successful user login that generates a JWT token.
	 */
	@Test(enabled = true, priority = 8)
	public void token() {
		
		RestAssured.baseURI = BaseUrl;
		
		JSONObject requestBody = new JSONObject();
		
		 requestBody.put("username", "michael"); // Username for login
		 requestBody.put("password", "success-password"); // Correct Password
		 
		 given()
		    .contentType(ContentType.JSON)
		    .body(requestBody.toString()) // Send JSON body
		 .when()
		    .post("/login") // Attempt to login
		 .then()
		    .statusCode(200) // Assert the status code is 200 for success
		    .log().all(); // Log the response for debugging
		  
	}
	
	/**
	 * Test case to retrieve default metadata about the API.
	 * 
	 */
	@Test(enabled = true, priority = 9)
	public void retrieve() {
		
		RestAssured.baseURI = BaseUrl;
		
		given()
		    .get("/")  // Get root endpoint for metadata
		.then()
		    .statusCode(200) // Assert the status code is 200
		    .contentType(ContentType.JSON) // Assert content type
		    .body("status", equalTo("Awesome! You have reached dummy JSON APIs."
				+ " Go to https://beeceptor.com/mock-server/json-placeholder and "
				+ "find the request paths you want to use. "
				+ "If you are using trailing slashes and this came up, "
				+ "please remove those to see the actual response.")) // Validate the status message
		    .log().all(); // Log the response for debugging
	}
}

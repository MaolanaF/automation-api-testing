package com.a3.api_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethodTest{
    
    @Test
    public void GetUserWithNoAppId() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Set the request header with an empty app-id (which should trigger the error)
        httpRequest.header("app-id", "");

        // Set the content type of the request (JSON)
        httpRequest.contentType(ContentType.JSON);

        // Specify the user ID to retrieve
        String userId = "60d0fe4f5311236168a109ac";

        // Send GET request to retrieve user information by ID
        Response response = httpRequest.request(Method.GET, "/user/" + userId);

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 403, response.getStatusCode());
        
        // Assert that the response body contains the expected error message
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected error message", responseBody.contains("APP_ID_MISSING"));
    }

    @Test
    public void GetUserWithAppIdInvalid(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Set the request header with an empty app-id (which should trigger the error)
        httpRequest.header("app-id", "662e51efbb70a7543a25956");

        // Set the content type of the request (JSON)
        httpRequest.contentType(ContentType.JSON);

        // Specify the user ID to retrieve
        String userId = "60d0fe4f5311236168a109ac";

        // Send GET request to retrieve user information by ID
        Response response = httpRequest.request(Method.GET, "/user/" + userId);

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 403, response.getStatusCode());
        
        // Assert that the response body contains the expected error message
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected error message", responseBody.contains("APP_ID_NOT_EXIST"));
    }

    @Test
    public void GetUserWithAppIdValidAndUserIdInvalid(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Set the request header with an empty app-id (which should trigger the error)
        httpRequest.header("app-id", "662e51efbb70a7543a259560");

        // Set the content type of the request (JSON)
        httpRequest.contentType(ContentType.JSON);

        // Specify the user ID to retrieve
        String userId = "60d0fe4f5311236168a109ca";

        // Send GET request to retrieve user information by ID
        Response response = httpRequest.request(Method.GET, "/user/" + userId);

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 404, response.getStatusCode());
        
        // Assert that the response body contains the expected error message
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected error message", responseBody.contains("RESOURCE_NOT_FOUND"));
    }

    @Test
    public void GetUserWithAppIdValidAndUserIdValid(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Set the request header with an empty app-id (which should trigger the error)
        httpRequest.header("app-id", "662e51efbb70a7543a259560");

        // Set the content type of the request (JSON)
        httpRequest.contentType(ContentType.JSON);

        // Specify the user ID to retrieve
        String userId = "60d0fe4f5311236168a109ac";

        // Send GET request to retrieve user information by ID
        Response response = httpRequest.request(Method.GET, "/user/" + userId);

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

       // Assert that the response status code 
       assertEquals("Unexpected status code", 200, response.getStatusCode());
    }

    @Test
    public void GetUserWithUserIdInvalid(){
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        // Set the request header with an empty app-id (which should trigger the error)
        httpRequest.header("app-id", "662e51efbb70a7543a259560");

        // Set the content type of the request (JSON)
        httpRequest.contentType(ContentType.JSON);

        // Specify the user ID to retrieve
        String userId = "abc";

        // Send GET request to retrieve user information by ID
        Response response = httpRequest.request(Method.GET, "/user/" + userId);

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 400, response.getStatusCode());
        
        // Assert that the response body contains the expected error message
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected error message", responseBody.contains("PARAMS_NOT_VALID"));
    }

}
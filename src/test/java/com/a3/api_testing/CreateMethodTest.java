package com.a3.api_testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateMethodTest {

    @Test
    public void CreateUser() {
        String title = "mr",
            firstName = "Zacky",
            lastName = "Faishal",
            picture = "",
            gender = "male",
            email = "paisall1@google.com",
            dateOfBirth = "2002-06-30",
            phone = "0811111111",
            street = "123 Palasari 1",
            city = "Bandung",
            state = "Jawa Barat",
            country = "Indonesia",
            timezone = "-10:00";
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("app-id", "662e51efbb70a7543a259560");
        httpRequest.contentType(ContentType.JSON);

        // Body for creating a new user
        String requestBody = "{\n" +
            "    \"title\": \""+title+"\",\n" +
            "    \"firstName\": \""+firstName+"\",\n" +
            "    \"lastName\": \""+lastName+"\",\n" +
            "    \"picture\": \""+picture+"\",\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
            "    \"phone\": \""+phone+"\",\n" +
            "    \"location\": {\n" +
            "        \"street\": \""+street+"\",\n" +
            "        \"city\": \""+city+"\",\n" +
            "        \"state\": \""+state+"\",\n" +
            "        \"country\": \""+country+"\",\n" +
            "        \"timezone\": \""+timezone+"\"\n" +
            "    }\n" +
            "}";

        // Set the request body
        httpRequest.body(requestBody);

        // Send POST request to create a new user
        Response response = httpRequest.request(Method.POST, "/user/create");

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 200, response.getStatusCode());
    }

    @Test
    public void CreateUserEmailAlreadyUse() {
        String title = "mr",
            firstName = "Zacky",
            lastName = "Faishal",
            picture = "",
            gender = "male",
            email = "paisall1@google.com",
            dateOfBirth = "2002-06-30",
            phone = "0811111111",
            street = "123 Palasari 1",
            city = "Bandung",
            state = "Jawa Barat",
            country = "Indonesia",
            timezone = "-10:00";
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("app-id", "662e51efbb70a7543a259560");
        httpRequest.contentType(ContentType.JSON);

        // Body for creating a new user
        String requestBody = "{\n" +
            "    \"title\": \""+title+"\",\n" +
            "    \"firstName\": \""+firstName+"\",\n" +
            "    \"lastName\": \""+lastName+"\",\n" +
            "    \"picture\": \""+picture+"\",\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
            "    \"phone\": \""+phone+"\",\n" +
            "    \"location\": {\n" +
            "        \"street\": \""+street+"\",\n" +
            "        \"city\": \""+city+"\",\n" +
            "        \"state\": \""+state+"\",\n" +
            "        \"country\": \""+country+"\",\n" +
            "        \"timezone\": \""+timezone+"\"\n" +
            "    }\n" +
            "}";

        // Set the request body
        httpRequest.body(requestBody);

        // Send POST request to create a new user
        Response response = httpRequest.request(Method.POST, "/user/create");

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 400, response.getStatusCode());
    }

    @Test
    public void CreateUser50CharLastName() {
        String title = "mr",
            firstName = "Zacky",
            lastName = "jekijekijekijekijekijekijekijerrrrrrrrrrrrrrrrrrrr",
            picture = "",
            gender = "male",
            email = "abror12@google.com",
            dateOfBirth = "2002-06-30",
            phone = "0811111111",
            street = "123 Palasari 1",
            city = "Bandung",
            state = "Jawa Barat",
            country = "Indonesia",
            timezone = "-10:00";
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("app-id", "662e51efbb70a7543a259560");
        httpRequest.contentType(ContentType.JSON);

        // Body for creating a new user
        String requestBody = "{\n" +
            "    \"title\": \""+title+"\",\n" +
            "    \"firstName\": \""+firstName+"\",\n" +
            "    \"lastName\": \""+lastName+"\",\n" +
            "    \"picture\": \""+picture+"\",\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
            "    \"phone\": \""+phone+"\",\n" +
            "    \"location\": {\n" +
            "        \"street\": \""+street+"\",\n" +
            "        \"city\": \""+city+"\",\n" +
            "        \"state\": \""+state+"\",\n" +
            "        \"country\": \""+country+"\",\n" +
            "        \"timezone\": \""+timezone+"\"\n" +
            "    }\n" +
            "}";

        // Set the request body
        httpRequest.body(requestBody);

        // Send POST request to create a new user
        Response response = httpRequest.request(Method.POST, "/user/create");

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 200, response.getStatusCode());
    }

    @Test
    public void CreateUserBlankFirstName() {
        String title = "mr",
            firstName = "",
            lastName = "Faishal",
            picture = "",
            gender = "male",
            email = "jeki21@google.com",
            dateOfBirth = "2002-06-30",
            phone = "0811111111",
            street = "123 Palasari 1",
            city = "Bandung",
            state = "Jawa Barat",
            country = "Indonesia",
            timezone = "-10:00";
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("app-id", "662e51efbb70a7543a259560");
        httpRequest.contentType(ContentType.JSON);

        // Body for creating a new user
        String requestBody = "{\n" +
            "    \"title\": \""+title+"\",\n" +
            "    \"firstName\": \""+firstName+"\",\n" +
            "    \"lastName\": \""+lastName+"\",\n" +
            "    \"picture\": \""+picture+"\",\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
            "    \"phone\": \""+phone+"\",\n" +
            "    \"location\": {\n" +
            "        \"street\": \""+street+"\",\n" +
            "        \"city\": \""+city+"\",\n" +
            "        \"state\": \""+state+"\",\n" +
            "        \"country\": \""+country+"\",\n" +
            "        \"timezone\": \""+timezone+"\"\n" +
            "    }\n" +
            "}";

        // Set the request body
        httpRequest.body(requestBody);

        // Send POST request to create a new user
        Response response = httpRequest.request(Method.POST, "/user/create");

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 400, response.getStatusCode());
    }

    @Test
    public void CreateUserBlankEmail() {
        String title = "mr",
            firstName = "Zacky",
            lastName = "Faishal",
            picture = "",
            gender = "male",
            email = "",
            dateOfBirth = "2002-06-30",
            phone = "0811111111",
            street = "123 Palasari 1",
            city = "Bandung",
            state = "Jawa Barat",
            country = "Indonesia",
            timezone = "-10:00";
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("app-id", "662e51efbb70a7543a259560");
        httpRequest.contentType(ContentType.JSON);

        // Body for creating a new user
        String requestBody = "{\n" +
            "    \"title\": \""+title+"\",\n" +
            "    \"firstName\": \""+firstName+"\",\n" +
            "    \"lastName\": \""+lastName+"\",\n" +
            "    \"picture\": \""+picture+"\",\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"email\": \""+email+"\",\n" +
            "    \"dateOfBirth\": \""+dateOfBirth+"\",\n" +
            "    \"phone\": \""+phone+"\",\n" +
            "    \"location\": {\n" +
            "        \"street\": \""+street+"\",\n" +
            "        \"city\": \""+city+"\",\n" +
            "        \"state\": \""+state+"\",\n" +
            "        \"country\": \""+country+"\",\n" +
            "        \"timezone\": \""+timezone+"\"\n" +
            "    }\n" +
            "}";

        // Set the request body
        httpRequest.body(requestBody);

        // Send POST request to create a new user
        Response response = httpRequest.request(Method.POST, "/user/create");

        // Print the status and response body of the API
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response => " + response.prettyPrint());

        // Assert that the response status code
        assertEquals("Unexpected status code", 400, response.getStatusCode());
    }

}
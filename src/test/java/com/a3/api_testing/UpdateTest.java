package com.a3.api_testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Test.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class UpdateTest {
    private final String appId = "662e5c0abb70a7055e2595ba";
    private final String userId = "60d0fe4f5311236168a10a27";   
    private static final String urlBase = "https://dummyapi.io/data/v1"; 

@Test
    public void testUpdateAllData() {
        String requestBody = "{\n" +
        "  \"title\": \"mr\",\n" +
        "  \"firstName\": \"Tomothy\",\n" +
        "  \"lastName\": \"Hawkins\",\n" +
        "  \"picture\": \"https://randomuser.me/api/portraits/med/men/48.jpg\",\n" +
        "  \"gender\": \"male\",\n" +
        "  \"email\": \"tomothy.hawkins@example.com\",\n" +
        "  \"dateOfBirth\": \"1976-11-19T00:31:34.945Z\",\n" +
        "  \"phone\": \"01539558087\",\n" +
        "  \"location\": {\n" +
        "    \"street\": \"5508, New Street\",\n" +
        "    \"city\": \"Plymouth\",\n" +
        "    \"state\": \"Berkshire\",\n" +
        "    \"country\": \"United Kingdom\",\n" + // Tambahkan tanda koma di sini
        "    \"timezone\": \"-10:00\"\n" + // Perbaiki kesalahan sintaks
        "  }\n" +
        "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put(urlBase + "/user/" + userId)
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Tomothy"))
            .body("lastName", equalTo("Hawkins"))
            .body("picture", equalTo("https://randomuser.me/api/portraits/med/men/48.jpg"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("tomothy.hawkins@example.com"))
            .body("dateOfBirth", equalTo("1976-11-19T00:31:34.945Z"))
            .body("phone", equalTo("01539558087"))
            .body("location.street", equalTo("5508, New Street"))
            .body("location.city", equalTo("Plymouth"))
            .body("location.state", equalTo("Berkshire"))
            .body("location.country", equalTo("United Kingdom"))
            .body("location.timezone", equalTo("-10:00"));
    }

    @Test
    public void testUpdateFirstNameTwoChar() {
        String requestBody = "{\n" +
        "  \"firstName\": \"su\"\n" +
        "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put(urlBase + "/user/" + userId)
        .then()
            .statusCode(200)
            .body("firstName", equalTo("su"));
    }

    @Test
    public void testUpdateFirstName50Char() {
        String requestBody = "{\n" +
        "  \"firstName\": \"aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy\"\n" +
        "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put(urlBase + "/user/" + userId)
        .then()
            .statusCode(200)
            .body("firstName", equalTo("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy"));
    }


    @Test
    public void testUpdateFirstLastNameithNum() {
        String requestBody = "{\n" +
        "  \"firstName\": \"1\",\n" +
        "  \"lastName\": \"2\"\n" +
        "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put(urlBase + "/user/" + userId)
        .then()
            .statusCode(400); //BadRequest
    }

    @Test
    public void testUpdateIdInvalid() {
        String requestBody = "{\n" +
        "  \"title\": \"mr\",\n" +
        "  \"firstName\": \"Tomothy\",\n" +
        "  \"lastName\": \"Hawkins\",\n" +
        "  \"picture\": \"https://randomuser.me/api/portraits/med/men/48.jpg\",\n" +
        "  \"gender\": \"male\",\n" +
        "  \"email\": \"tomothy.hawkins@example.com\",\n" +
        "  \"dateOfBirth\": \"1976-11-19T00:31:34.945Z\",\n" +
        "  \"phone\": \"01539558087\",\n" +
        "  \"location\": {\n" +
        "    \"street\": \"5508, New Street\",\n" +
        "    \"city\": \"Plymouth\",\n" +
        "    \"state\": \"Berkshire\",\n" +
        "    \"country\": \"United Kingdom\",\n" + // Tambahkan tanda koma di sini
        "    \"timezone\": \"-10:00\"\n" + // Perbaiki kesalahan sintaks
        "  }\n" +
        "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put(urlBase + "/user/" + "60d0fe4f5311236168a12a90")
        .then()
            .statusCode(404);
    }

}

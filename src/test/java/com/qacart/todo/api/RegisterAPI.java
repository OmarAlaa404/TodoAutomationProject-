package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterAPI {

    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;  // Attribute to store the user's first name

    // Getter for accessToken
    public String getAccessToken() {
        return this.accessToken;
    }

    // Getter for restAssuredCookies
    public List<Cookie> getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    // Getter for userId
    public String getUserId() {
        return this.userId;
    }

    // Getter for firstName
    public String getFirstName() {
        return this.firstName;
    }

    // Method to register a new user
    public void register() {
        // Generate a random user using UserUtils
        UserUtils userUtils = new UserUtils();
        User randomUser = userUtils.generateRandomUser();

        // Register the user via API
        Response response = given()
                .baseUri(System.getProperty("baseUri", "https://todo.qacart.com"))  // Externalized base URL
                .header("Content-Type", "application/json")
                .body(randomUser)
                .log().all()  // Log all request details
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)  // API endpoint for user registration
                .then()
                .log().all()  // Log all response details
                .assertThat().statusCode(201)  // Assert that the status code is 201 (Created)
                .extract().response();

        // Extract information from response
        restAssuredCookies = response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }
}

package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * RegisterAPI class handles the user registration process via API and stores relevant user details.
 */
public class RegisterAPI {

    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    /**
     * Gets the access token of the registered user.
     *
     * @return the access token as a String.
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Gets the cookies returned from the registration API call.
     *
     * @return a list of RestAssured cookies.
     */
    public List<Cookie> getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    /**
     * Gets the user ID of the registered user.
     *
     * @return the user ID as a String.
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * Gets the first name of the registered user.
     *
     * @return the first name as a String.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Registers a new user using the API and stores the relevant details.
     */
    public void register() {
        // Generate a random user using UserUtils
        UserUtils userUtils = new UserUtils();
        User randomUser = userUtils.generateRandomUser();

        // Register the user via API
        Response response = given()
                .baseUri(System.getProperty("baseUri", "https://todo.qacart.com"))  // Externalized base URL
                .header("Content-Type", "application/json")
                .body(randomUser)
                .log().ifValidationFails()  // Log request details only if validation fails
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)  // API endpoint for user registration
                .then()
                .log().ifValidationFails()  // Log response details only if validation fails
                .assertThat().statusCode(201)  // Assert that the status code is 201 (Created)
                .extract().response();

        // Extract and store information from response
        this.restAssuredCookies = response.getDetailedCookies().asList();
        this.accessToken = response.path("access_token");
        this.userId = response.path("userID");
        this.firstName = response.path("firstName");
    }
}

package com.qacart.todo;

import com.qacart.todo.objects.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Dummy {

    public static void main(String[] args) {

        User user = new User("Hatem", "Hatamleh", "test9@example.com", "1234566");

        Response response = given()
                .baseUri("https://todo.qacart.com")  // Base URL for the API
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/api/v1/users/register")  // Endpoint for user registration
                .then()
                .extract().response();

        // Extract the userID from the response
        String userID = response.path("userID");
        response.cookies();  // Retrieve cookies (if necessary)

        // Print the extracted userID
        System.out.println(userID);
    }
}
